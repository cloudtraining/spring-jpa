package com.example.springjpa.hello;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Transactional
	public Customer findById(long id) {
		Optional<Customer> cust = repository.findById(1L);
		Customer customer = cust.get();
		customer.getPhones().size();
		return customer;
	}

}
