package com.niranjan.axon.demo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateAccountCommand {
	
	@TargetAggregateIdentifier
	private String id;
	
	private String accountCreatorName;
	
	public CreateAccountCommand(String id, String accountCreatorName) {
		this.id = id;
		this.accountCreatorName = accountCreatorName;
	}
}
