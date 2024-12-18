package com.mina.dev.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "glue-schema-registry.aws")
public record GlueProperties(
    String region,
    String registryName) {

}
