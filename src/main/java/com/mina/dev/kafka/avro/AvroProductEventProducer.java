package com.mina.dev.kafka.avro;

import com.mina.dev.kafka.domain.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;


@AllArgsConstructor
@Slf4j
public class AvroProductEventProducer {

  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final String productAvroTopic;

  /**
   * Converts a Product object to an Avro DTO and sends it to the Kafka topic asynchronously.
   *
   * @param product The product data to be sent.
   */
  public void sendProductEvent(Product product) {
    log.info("Preparing to send product to Kafka: {}", product);
    ProductAvroDto dto = AvroDataFactory.createProductAvroDto(product);
    sendAsync(productAvroTopic, dto, product.getId());
  }

  /**
   * Sends a record asynchronously to a Kafka topic.
   *
   * @param topic     The Kafka topic to send the message to.
   * @param data      The Avro data object.
   * @param productId The product ID, used as the key for the message.
   */
  private void sendAsync(String topic, SpecificRecordBase data, Long productId) {
    try {
      ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic, null, String.valueOf(productId), data);
      kafkaTemplate.send(producerRecord).whenComplete((result, failure) -> {
        if (failure == null) {
          log.info("Successfully sent product event for productId {}", productId);
        } else {
          log.error("Failed to send product event for productId {}", productId, failure);
        }
      });
    } catch (Exception e) {
      log.error("Unable to send product event for productId {}", productId, e);
    }
  }
}
