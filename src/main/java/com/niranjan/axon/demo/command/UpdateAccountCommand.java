package com.niranjan.axon.demo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import lombok.Getter;

public class UpdateAccountCommand {

  @TargetAggregateIdentifier
  @Getter
  private String id;

  @Getter
  private double balance;

  public UpdateAccountCommand(String id, double balance) {
    this.id = id;
    this.balance = balance;
  }

}
