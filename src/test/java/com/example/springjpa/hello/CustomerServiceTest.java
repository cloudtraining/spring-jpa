package com.example.springjpa.hello;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

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
public class CustomerServiceTest {
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceTest.class);
	@Autowired
	private CustomerService service;

	@Test
	public void findById() {
		Customer customer = service.findById(1L);
		int size = customer.getPhones().size();
		assertEquals(2, size);
		assertEquals("Customer(id=1, firstName=Jack, lastName=Bauer, phones=[Phone(id=2, type=home, number=309.123.1234), Phone(id=3, type=cell, number=309.321.4321)])", customer.toString());
	}
	
	@Test
	@Transactional
	public void findAll() {
		Iterable<Customer> customers = service.findAllCustomers();
		assertEquals(customers.spliterator().getExactSizeIfKnown(), 5);
		for (Customer customer : customers) {
			log.info(customer.toString());
		}
	}
	
}
