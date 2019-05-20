package com.example.springjpa.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {
	
	@Test
	public void gettersAndSetters() {
		Customer customer = new Customer();
		customer.setFirstName("silly first name");
		customer.setLastName("silly last name");
		assertEquals("silly first name", customer.getFirstName());
		assertEquals("silly last name", customer.getLastName());
	}

}
