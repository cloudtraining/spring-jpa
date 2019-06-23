package com.example.springjpa.hello;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springjpa.SpringJpaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJpaApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes= {CustomerRepositoryPopulation.class})
public class CustomerRepositoryTest implements ApplicationContextAware{
	@Autowired
	private Environment env;

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
	@Transactional // needed to support lazy loading
	public void findAllCustomers() {
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		Iterable<Customer> customers = repository.findAll();
		for (Customer customer : customers) {
			log.info(customer.toString());
		}
		assertEquals(customers.spliterator().getExactSizeIfKnown(), 5);
	}

	@Transactional // needed to support lazy loading
	@Test
	public void findById() {
		Optional<Customer> cust = repository.findById(1L);
		Customer customer = cust.get();
		dumpProperties();
		int size = customer.getPhones().size();
		assertEquals(2, size);
		cust.ifPresent(customer1 -> {log.info(String.format("returned customer from findById %s", customer1.toString())); });
		assertEquals("Customer(id=1, firstName=Jack, lastName=Bauer, phones=[Phone(id=1, type=home, number=309.123.1234), Phone(id=2, type=cell, number=309.321.4321)])", customer.toString());
	}
	
	@Test
	public void findByLastName() {
		List<Customer> customers = repository.findByLastName("Bauer");
		assertEquals(2, customers.size());
	}
	
	@Test
	public void findByFirstName() {
		List<Customer> customers = repository.findByFirstName("David");
		assertEquals(1, customers.size());
		Customer customer = customers.get(0);
		assertEquals("David", customer.getFirstName());
		assertEquals("Palmer", customer.getLastName());
	}
    public void dumpProperties() {
    	Properties properties = System.getProperties();
    	Set<String> stringPropertyNames = properties.stringPropertyNames();
        System.out.println("EYECATCHER: System.properties");
    	for (String key : stringPropertyNames) {
    		System.out.println(String.format("\t key[%s] value[%s]", key, properties.getProperty(key)));
		}
    	System.out.println(env.toString());
    	String propKey = "spring.jpa.properties.hibernate.current_session_context_class";
    	
    	System.out.println("EYECATCHER: Environment properties");
    	System.out.println(String.format("\t key[%s] value[%s]", propKey, env.getProperty(propKey)));
    }


	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println("EYECATCHER: Spring context properties");
		for (String beanName : beanDefinitionNames) {
			System.out.println(String.format("\t beanName[%s] value[%s]", beanName, context.getBean(beanName)));
		}
		
	}
}
