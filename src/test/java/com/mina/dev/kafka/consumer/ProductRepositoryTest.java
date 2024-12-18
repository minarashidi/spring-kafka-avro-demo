package com.mina.dev.kafka.consumer;

import com.mina.dev.kafka.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositoryTest {

  @Autowired
  private ProductRepository productRepository;

//  @Test
//  public void testSaveProduct() {
//    Product product = new Product();
//    product.setProductId("1");
//    product.setProductName("Laptop");
//    product.setPrice(999.99);
//
//    productRepository.save(product);
//
//    // Test product retrieval
//    Product retrievedProduct = productRepository.findById("1").orElse(null);
//    assertNotNull(retrievedProduct);
//    assertEquals("Laptop", retrievedProduct.getProductName());
//  }
}