package com.example.springjpa.hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public List<Customer> findByLastName(String lastName);
	
	public List<Customer> findByFirstName(String firstName);

}
