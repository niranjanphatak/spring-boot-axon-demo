package com.niranjan.axon.demo.aggrigate;

import java.io.Serializable;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;
import com.niranjan.axon.demo.command.CreateAccountCommand;
import com.niranjan.axon.demo.command.UpdateAccountCommand;
import com.niranjan.axon.demo.events.AccountCreatedEvent;
import com.niranjan.axon.demo.events.AccountUpdatedEvent;

@Aggregate
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
    this.balance = 0.0;

    Assert.hasLength(id, "Missing ID");
    Assert.hasLength(ownerName, "Missing Account Creator Name");

    AggregateLifecycle.apply(new AccountCreatedEvent(this.id, this.ownerName, this.balance));
  }

  public BankAccount() {
    // constructor needed for reconstruction
  }

  @EventSourcingHandler
  public void onAccountCreatedEvent(AccountCreatedEvent accountCreatedEvent) {
    this.id = accountCreatedEvent.getId();
    this.ownerName = accountCreatedEvent.getAccountCreator();
    this.balance = accountCreatedEvent.getBalance();
  }

  @CommandHandler
  public void UpdateAccountCommandHandler(UpdateAccountCommand updateAccountCommand) {
    // Perform any validations if any
    // Create Event
    AggregateLifecycle.apply(new AccountUpdatedEvent(this.id, updateAccountCommand.getBalance()));
    
  }
  
  @EventSourcingHandler
  public void onAccountUpdatedEvent(AccountUpdatedEvent accountUpdatedEvent) {
    this.balance = accountUpdatedEvent.getBalance();
  }

}
