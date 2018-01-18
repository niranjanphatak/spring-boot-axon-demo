package com.niranjan.axon.demo.controller;

import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.niranjan.axon.demo.command.CreateAccountCommand;

/**
 * 
 * @author niranjan Bank Account Controller to handle all incoming REST requests
 */
@RestController
@RequestMapping("/account")
public class BankAccountController {

  private CommandGateway commandGateway;

  public BankAccountController(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @PostMapping("/create")
  public boolean createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
    this.commandGateway.send(
        new CreateAccountCommand(UUID.randomUUID().toString(), createAccountRequest.getName()));
    return true;
  }

}
