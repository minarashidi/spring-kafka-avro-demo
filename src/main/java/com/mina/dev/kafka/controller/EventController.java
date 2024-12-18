package com.mina.dev.kafka.controller;

import com.mina.dev.kafka.avro.AvroProductEventProducer;
import com.mina.dev.kafka.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

  @Autowired
  private AvroProductEventProducer producer;

  @PostMapping("/events")
  public String sendMessage(@RequestBody Product product) {
    producer.sendProductEvent(product);
    return "message published !";
  }
}
