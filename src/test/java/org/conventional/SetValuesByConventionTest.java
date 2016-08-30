package org.conventional;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Basic example on populating POJOs automatically based on conventions.
 * @author mefernandez
 *
 */
public class SetValuesByConventionTest {

	/**
	 * Some verbose test data setup.
	 */
	@Test
	public void testSaveCustomer() {
		// Set up test data
		Customer customer = Conventional.create(Customer.class);
		
		// Test something
		Repository repository = new Repository();
		repository.save(customer);
		assertEquals(1, repository.countByName("Name"));
	}

}
