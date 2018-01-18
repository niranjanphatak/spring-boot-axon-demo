package com.niranjan.axon.demo.domain;

import java.io.Serializable;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import com.niranjan.axon.demo.command.CreateAccountCommand;

@AggregateRoot
public class BankAccount implements Serializable {

  private static final long serialVersionUID = 1L;

  @AggregateIdentifier
  private String id;

  private double balance;

  private String ownerName;

  @CommandHandler
  public BankAccount(CreateAccountCommand createAccountCommand) {
    this.id = createAccountCommand.getId();
    this.ownerName = createAccountCommand.getAccountCreatorName();

    // TODO: Generate Bank Account create event at this point
  }

}
