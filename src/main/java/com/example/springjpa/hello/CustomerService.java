package com.example.springjpa.hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer findById(long id) {
		Optional<Customer> cust = repository.findById(1L);
		Customer customer = cust.get();
		customer.getPhones().size();
		return customer;
	}

}
