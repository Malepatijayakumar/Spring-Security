package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@RequestMapping(method = RequestMethod.GET,value="/contact")
	public ResponseEntity<String> getContacts(){
		return new ResponseEntity<String>("Here are contact details from DB",HttpStatus.OK);
	}
}
