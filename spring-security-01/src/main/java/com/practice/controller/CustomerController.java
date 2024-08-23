package com.practice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.CustomerDTO;
import com.practice.entity.Customer;
import com.practice.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerRepository customerRepository;
	private final PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody CustomerDTO customerDTO) {
		var customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);

		var encodedPwd = passwordEncoder.encode(customerDTO.getPwd());
		customer.setPwd(encodedPwd);

		var savedCustomer = customerRepository.save(customer);

		if (savedCustomer != null) {
			return new ResponseEntity<String>("Registration Successful", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed to Register an user", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}