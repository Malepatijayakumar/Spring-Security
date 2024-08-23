package com.practice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Optional<Customer> findByEmail(String email);
}