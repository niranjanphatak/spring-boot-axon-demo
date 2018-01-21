package com.niranjan.axon.demo.events;

import lombok.Getter;

public class AccountCreatedEvent {
  
  @Getter
  private String id;
  
  @Getter
  private String accountCreator;
  
  @Getter
  private double balance;
  
  public AccountCreatedEvent(String id, String accountCreator, double balance) {
    this.id = id;
    this.accountCreator = accountCreator;
    this.balance = balance;
  }
}
