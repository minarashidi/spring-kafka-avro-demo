package com.mina.dev.kafka.config;

import com.amazonaws.services.schemaregistry.serializers.GlueSchemaRegistryKafkaSerializer;
import com.amazonaws.services.schemaregistry.utils.AWSSchemaRegistryConstants;
import com.mina.dev.kafka.avro.AvroProductEventProducer;
import com.mina.dev.kafka.avro.GlueSchemaUploader;
import com.mina.dev.kafka.avro.ProductAvroDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.CooperativeStickyAssignor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.glue.GlueClient;


@Configuration
@EnableConfigurationProperties({KafkaProperties.class, GlueProperties.class})
@EnableTransactionManagement
@Slf4j
public class AppConfig {

  @Bean
  ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
    var productEventsConsumer = kafkaProperties.consumer();
    return createKafkaConsumerFactory(kafkaProperties, productEventsConsumer.groupId(), productEventsConsumer.autoOffsetReset());
  }

  private ConcurrentKafkaListenerContainerFactory<String, String> createKafkaConsumerFactory(KafkaProperties kafkaProperties,
      String groupId, String autoOffsetReset) {

    var props = new HashMap<String, Object>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.bootstrapServers());
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
    props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, List.of(CooperativeStickyAssignor.class));
//    configureSasl(kafkaProperties, props);

    var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
    factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(props, StringDeserializer::new, StringDeserializer::new));
    factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
    return factory;
  }

  @Bean
  public AvroProductEventProducer avroProductEventProducer(KafkaTemplate<String, Object> analyticsKafkaTemplate,
      KafkaProperties kafkaProperties) {
    return new AvroProductEventProducer(analyticsKafkaTemplate, kafkaProperties.producer().topic()
    );
  }

  @Bean
  KafkaTemplate<String, Object> avroKafkaTemplate(KafkaProperties kafkaProperties, GlueProperties glueProperties) {

    System.setProperty("software.amazon.awssdk.http.service.impl", "software.amazon.awssdk.http.apache.ApacheSdkHttpService");

    var props = new HashMap<String, Object>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.bootstrapServers());
    props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, false);
    props.put(AWSSchemaRegistryConstants.AWS_REGION, glueProperties.region());
    props.put(AWSSchemaRegistryConstants.DATA_FORMAT, "AVRO");
    props.put(AWSSchemaRegistryConstants.SCHEMA_AUTO_REGISTRATION_SETTING, "false");
    props.put(AWSSchemaRegistryConstants.REGISTRY_NAME, glueProperties.registryName());
//    configureSasl(kafkaProperties, props);

    var producerFactory = new DefaultKafkaProducerFactory<>(props, StringSerializer::new, GlueSchemaRegistryKafkaSerializer::new);

    return new KafkaTemplate<>(producerFactory);
  }

//  @Bean
//  public GlueSchemaUploader schemaUploader(KafkaProperties kafkaProperties, GlueProperties glueProperties) {
//    var avroProductEvents = kafkaProperties.producer();
//
//    System.setProperty("software.amazon.awssdk.http.service.impl", "software.amazon.awssdk.http.apache.ApacheSdkHttpService");
//
//    var glueClient = GlueClient.builder()
//        .region(Region.of(glueProperties.region()))
//        .credentialsProvider(WebIdentityTokenFileCredentialsProvider.create())
//        .build();
//
//    var schemaMap = Map.of(
//        avroProductEvents.topic(), ProductAvroDto.getClassSchema().toString()
//    );
//
//    return new GlueSchemaUploader(glueClient, glueProperties.registryName(), schemaMap);
//  }

}
