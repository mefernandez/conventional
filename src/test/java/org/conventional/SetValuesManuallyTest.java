package org.conventional;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * This is just an example to build up the case 
 * for populating POJOs automatically based on conventions.
 * @author mefernandez
 *
 */
public class SetValuesManuallyTest {

	/**
	 * Some verbose test data setup.
	 */
	@Test
	public void testSaveCustomer() {
		// Set up test data
		Customer customer = new Customer();
		customer.setName("John Doe");
		Address address = new Address();
		address.setStreet("21B Baker Street");
		Order order = new Order();
		LineItem item = new LineItem();
		item.setQuantity(10);
		item.setPrice(new BigDecimal("1.05"));
		order.addLineItem(item);
		
		// Test something
		Repository repository = new Repository();
		repository.save(customer);
		assertEquals(1, repository.countByName("John Doe"));
	}

}
