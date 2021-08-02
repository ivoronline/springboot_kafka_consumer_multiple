package com.ivoronline.springboot_kafka_consumer_multiple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

  @Autowired Environment environment;

  @KafkaListener(topics = "Topic1", groupId = "group_id")
  public void consume(String message) throws IOException {
    String port = environment.getProperty("server.port");
    System.out.println(port + " Received: " + message);
  }

}

