package com.niranjan.axon.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class BankAccountController {

	
	@PostMapping("/create")
	public boolean createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
		//TODO: Add Controller Logic
		return true;
	}
}
