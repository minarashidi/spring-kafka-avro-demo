package com.mina.dev.kafka.service;

import com.mina.dev.kafka.domain.Product;
import com.mina.dev.kafka.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

  private final ProductRepository repository;

  public void insertIfNotExisting(Product product) {
    if (repository.existsById(product.getId())) {
      // If product already exists, we log or update it (depending on your use case).
      log.info("Product with ID {} already exists. Skipping insert.", product.getId());
    } else {
      // If the product doesn't exist, we insert it into the database.
      repository.save(product);
      log.info("Product inserted into the database: {}", product);
    }
  }

}

