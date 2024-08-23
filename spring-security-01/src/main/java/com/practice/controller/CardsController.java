package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@RequestMapping(method = RequestMethod.GET,value="/myCards")
	public ResponseEntity<String> getCards(){
		return new ResponseEntity<String>("Here are my card details from DB",HttpStatus.OK);
	}
}
