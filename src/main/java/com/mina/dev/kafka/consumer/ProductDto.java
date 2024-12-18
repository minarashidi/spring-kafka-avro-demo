package com.mina.dev.kafka.consumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Currency;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDto(@JsonProperty("id") String id,
                         @JsonProperty("name") String name,
                         @JsonProperty("price") BigDecimal price,
                         @JsonProperty("currency") Currency currency,
                         @JsonProperty("category") String category,
                         @JsonProperty("sub_category") String subCategory,
                         @JsonProperty("created_at") String createdAt,
                         @JsonProperty("updated_at") String updatedAt) {

}

