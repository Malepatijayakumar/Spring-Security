package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@RequestMapping(method =RequestMethod.GET ,value="/welcome")
	public ResponseEntity<String> getWelcomeMsg(){
		return new ResponseEntity<>("Welcome to spring boot application with security",HttpStatus.OK);
	}
}