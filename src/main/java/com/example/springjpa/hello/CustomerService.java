package com.example.springjpa.hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Transactional (propagation=Propagation.REQUIRED)
	public Customer findById(long id) {
		Optional<Customer> cust = repository.findById(1L);
		Customer customer = cust.get();
		customer.getPhones().size();
		return customer;
	}

	
	@Transactional (propagation=Propagation.REQUIRED)
	public Iterable<Customer> findAllCustomers() {
		Iterable<Customer> customers = repository.findAll();
		return customers;
	}
	
	
}
