package com.mina.dev.kafka.repository;

import com.mina.dev.kafka.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

  // Custom query to check if a product with the same ID exists
  boolean existsById(long productId);
}

