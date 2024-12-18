package com.mina.dev.kafka.avro;

import com.mina.dev.kafka.domain.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AvroDataFactory {

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");

  public static ProductAvroDto createProductAvroDto(Product product) {

    return ProductAvroDto.newBuilder()
        .setId(String.valueOf(product.getId()))
        .setName(product.getName())
        .setPrice(product.getPrice())
        .setCurrency(product.getCurrency())
        .setCategory(product.getCategory())
        .setSubCategory(product.getSubCategory())
        .setCreatedAt(product.getCreatedAt() != null ? formatDateTime(product.getCreatedAt()) : null)
        .setUpdatedAt(product.getUpdatedAt() != null ? formatDateTime(product.getUpdatedAt()) : null)
        .build();
  }

  private static String formatDateTime(String dateTime) {
    // Assuming dateTime is in ISO-8601 format
    return DATE_TIME_FORMATTER.format(LocalDateTime.parse(dateTime));
  }
}

