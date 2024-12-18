package com.mina.dev.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public record KafkaProperties(
    String bootstrapServers,
    Consumer consumer,
    Producer producer) {

  public record Consumer(
      String topic,
      boolean autostart,
      String groupId,
      String autoOffsetReset,
      int threads) {
  }

  public record Producer(
      int retries,
      String topic) {
  }
}

