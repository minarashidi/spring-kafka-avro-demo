package com.mina.dev.kafka.avro;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.glue.GlueClient;
import software.amazon.awssdk.services.glue.model.CreateSchemaRequest;
import software.amazon.awssdk.services.glue.model.EntityNotFoundException;
import software.amazon.awssdk.services.glue.model.GetSchemaRequest;
import software.amazon.awssdk.services.glue.model.RegisterSchemaVersionRequest;
import software.amazon.awssdk.services.glue.model.RegistryId;
import software.amazon.awssdk.services.glue.model.SchemaId;
import software.amazon.awssdk.services.glue.model.SchemaVersionStatus;

@Slf4j
@AllArgsConstructor
public class GlueSchemaUploader {

  private final GlueClient client;
  private final String registryName;
  private final Map<String, String> schemas;

  @PreDestroy
  public void closeClient() {
    if (client != null) {
      try {
        client.close();
        log.info("Glue client closed successfully.");
      } catch (Exception e) {
        log.warn("Failed to close Glue client.", e);
      }
    }
  }

  @PostConstruct
  public void uploadSchemas() {
    schemas.forEach(this::uploadSchema);
  }

  private void uploadSchema(String schemaName, String schemaDefinition) {
    log.info("Uploading schema: {}", schemaName);

    Long version = getSchemaVersion(schemaName);
    if (version == null) {
      log.info("Schema {} not found. Creating a new schema.", schemaName);
      createSchema(schemaName, schemaDefinition);
    } else {
      log.info("Schema {} already exists with version {}. Checking for updates.", schemaName, version);
      uploadSchemaDefinition(schemaName, version, schemaDefinition);
    }
  }

  private void createSchema(String schemaName, String schemaDefinition) {
    var response = client.createSchema(CreateSchemaRequest.builder()
        .schemaName(schemaName)
        .dataFormat("AVRO")
        .compatibility("FULL")
        .schemaDefinition(schemaDefinition)
        .registryId(RegistryId.builder().registryName(registryName).build())
        .build()
    );

    log.info("Created schema: {} | Version: {} | Status: {}",
        schemaName, response.latestSchemaVersion(), response.schemaStatus());
  }

  private void uploadSchemaDefinition(String schemaName, Long existingVersion, String schemaDefinition) {
    var response = client.registerSchemaVersion(RegisterSchemaVersionRequest.builder()
        .schemaId(schemaId(schemaName))
        .schemaDefinition(schemaDefinition)
        .build()
    );

    if (response.status() == SchemaVersionStatus.FAILURE) {
      log.error("Failed to upload schema definition for schema: {}\nDefinition: {}\nAWS Response: {}",
          schemaName, schemaDefinition, response);
      return;
    }

    if (existingVersion.equals(response.versionNumber())) {
      log.info("No changes detected for schema: {}", schemaName);
    } else {
      log.info("Updated schema: {} | New Version: {} | Status: {}",
          schemaName, response.versionNumber(), response.status());
    }
  }

  private Long getSchemaVersion(String schemaName) {
    try {
      return client.getSchema(GetSchemaRequest.builder()
              .schemaId(schemaId(schemaName))
              .build())
          .latestSchemaVersion();
    } catch (EntityNotFoundException e) {
      log.info("Schema {} not found in registry {}.", schemaName, registryName);
      return null;
    }
  }

  private SchemaId schemaId(String schemaName) {
    return SchemaId.builder()
        .registryName(registryName)
        .schemaName(schemaName)
        .build();
  }
}
