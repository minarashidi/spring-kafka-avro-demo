package com.mina.dev.kafka.domain;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product", schema = "product_catalog")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
  @SequenceGenerator(name = "product_generator", sequenceName = "seq_product", allocationSize = 1)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private Double price;

  @Column(name = "currency")
  private String currency;

  @Column(name = "category")
  private String category;

  @Column(name = "sub_category")
  private String subCategory;

  @Column(name = "created_at")
  private String createdAt;

  @Column(name = "updated_at")
  private String updatedAt;
}
