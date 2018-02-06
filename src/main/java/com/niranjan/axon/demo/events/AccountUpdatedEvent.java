package com.niranjan.axon.demo.events;

import lombok.Getter;

public class AccountUpdatedEvent {

  @Getter
  private String id;

  @Getter
  private double balance;

  public AccountUpdatedEvent(String id, double balance) {
    this.id = id;
    this.balance = balance;
  }
}
