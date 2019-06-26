package com.example.springjpa.hello;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Transactional (value=TxType.REQUIRED)
	public Customer findById(long id) {
		Optional<Customer> cust = repository.findById(1L);
		Customer customer = cust.get();
		customer.getPhones().size();
		return customer;
	}

	
	@org.springframework.transaction.annotation.Transactional (propagation=Propagation.REQUIRED)
	public Iterable<Customer> findAllCustomers() {
		Iterable<Customer> customers = repository.findAll();
		return customers;
	}
	
	
}
