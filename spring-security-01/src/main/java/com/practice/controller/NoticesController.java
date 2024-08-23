package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

	@RequestMapping(method = RequestMethod.GET,value="/notices")
	public ResponseEntity<String> getNotices(){
		return new ResponseEntity<String>("Here are notices from DB",HttpStatus.OK);
	}
}
