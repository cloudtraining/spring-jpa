package com.example.springjpa.hello;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springjpa.SpringJpaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes= {CustomerRepositoryPopulation.class})
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryTest.class);
	

	@Before
	public void setUp() throws Exception {
//		repository.save(new Customer("Jack", "Bauer"));
//		repository.save(new Customer("Chloe", "O'Brian"));
//		repository.save(new Customer("Kim", "Bauer"));
//		repository.save(new Customer("David", "Palmer"));
//		repository.save(new Customer("Michelle", "Dessler"));
	}
	
	@Test
	public void findAllCustomers() {
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		
	}

	@Test
	public void findById() {
		Optional<Customer> cust = repository.findById(1L);
		Customer customer = cust.get();
		int size = customer.getPhones().size();
		assertEquals(2, size);
		cust.ifPresent(customer1 -> {log.info(String.format("returned customer from findById %s", customer1.toString())); });
		assertEquals("Customer(id=1, firstName=Jack, lastName=Bauer, phones=[Phone(id=2, type=home, number=309.123.1234), Phone(id=3, type=cell, number=309.321.4321)])", customer.toString());
	}
	
	@Test
	public void findByLastName() {
		List<Customer> customers = repository.findByLastName("Bauer");
		assertEquals(2, customers.size());
	}

}
