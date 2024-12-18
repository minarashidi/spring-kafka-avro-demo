package com.mina.dev.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mina.dev.kafka.domain.Product;
import com.mina.dev.kafka.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class ProductConsumer {

  private final ObjectMapper objectMapper;
  private final ProductService productService;

  @KafkaListener(
      containerFactory = "kafkaListenerContainerFactory",
      topics = "${kafka.consumer.topic}",
      concurrency = "${kafka.consumer.threads}",
      clientIdPrefix = "product-${random.uuid}",
      autoStartup = "${kafka.consumer.autostart}"
  )
  public void onMessage(@Payload String payload, Acknowledgment acknowledgment) {
    try {
      // Deserialize the payload into ProductDto
      var productDto = objectMapper.readValue(payload, ProductDto.class);
      log.debug("Product event received: {}", productDto);

      // Map ProductDto to Product entity
      var product = mapToEntity(productDto);

      // Insert into the database or process further
      productService.insertIfNotExisting(product);
      log.info("Product event processed and inserted: {}", product);

      // Acknowledge the message after successful processing
      acknowledgment.acknowledge();
    } catch (Exception e) {
      log.warn("Unable to process product event: " + payload, e);
    }
  }

  private Product mapToEntity(ProductDto productDto) {
    return Product.builder()
        .name(productDto.name())
        .price(productDto.price() != null ? productDto.price().doubleValue() : null)
        .currency(productDto.currency() != null ? productDto.currency().toString() : null)
        .category(productDto.category())
        .subCategory(productDto.subCategory())
        .createdAt(productDto.createdAt())
        .updatedAt(productDto.updatedAt())
        .build();
  }
}

