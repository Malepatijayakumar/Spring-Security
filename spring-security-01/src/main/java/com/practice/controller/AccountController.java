package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@RequestMapping(method = RequestMethod.GET,value="/myAccount")
	public ResponseEntity<String> getAccount(){
		return new ResponseEntity<String>("Here are my account details from DB",HttpStatus.OK);
	}
}