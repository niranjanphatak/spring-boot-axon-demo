package com.niranjan.axon.demo;

import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringBootAxonDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootAxonDemoApplication.class, args);
  }

  @Configuration
  static class BankConfiguration {

    @Bean
    public EventStorageEngine eventStorageEngine() {
      return new InMemoryEventStorageEngine();
    }
  }
}
