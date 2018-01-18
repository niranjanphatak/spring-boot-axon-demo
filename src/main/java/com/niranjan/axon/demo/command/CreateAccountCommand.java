package com.niranjan.axon.demo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import lombok.Getter;

public class CreateAccountCommand {

  @TargetAggregateIdentifier
  @Getter
  private String id;

  @Getter
  private String accountCreatorName;

  public CreateAccountCommand(String id, String accountCreatorName) {
    this.id = id;
    this.accountCreatorName = accountCreatorName;
  }
  
}
