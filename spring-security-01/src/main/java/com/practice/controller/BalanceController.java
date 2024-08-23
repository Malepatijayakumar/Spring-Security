package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

	@RequestMapping(method = RequestMethod.GET, value = "/myBalance")
	public ResponseEntity<String> getBalance() {
		return new ResponseEntity<String>("Here are my balances from DB", HttpStatus.OK);
	}
}
