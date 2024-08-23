package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

	@RequestMapping(method = RequestMethod.GET,value="/myLoans")
	public ResponseEntity<String> getLoans(){
		return new ResponseEntity<String>("Here are my loan details from DB",HttpStatus.OK);
	}
}
