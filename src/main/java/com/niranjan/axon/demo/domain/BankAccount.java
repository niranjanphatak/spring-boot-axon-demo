package com.niranjan.axon.demo.domain;

import java.io.Serializable;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;

@AggregateRoot
public class BankAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@AggregateIdentifier
	private String id;
	
	private double balance;
	
	private String ownerName;
}
