# Conventional
Populate POJOs with dummy data based on conventions to make unit testing easier.

[Autopojo](https://github.com/minnal/autopojo) and [PODAM](http://devopsfolks.github.io/podam/) 
are two libraries I've seen with the same intent, only **Conventional** makes a strong emphasis
on **convention over configuration** to generate **predictable** test data.

# Show me how

Consider this example of domain model regarding a `Customer` and its `Orders`:

![Domain model](http://yuml.me/d1ee20df)

Let's say you want to do some unit testing and we need a fully populated `Customer`.
You can do it manually:

```java
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
```

That's quite verbose!

How about this instead?

```java
	/**
	 * Quick test data setup.
	 */
	@Test
	public void testSaveCustomer() {
		// Set up test data
		Customer customer = Conventional.create(Customer.class);
		
		// Test something
		Repository repository = new Repository();
		repository.save(customer);
		assertEquals("Name", customer.getName());
		assertEquals(1, repository.countByName("Name"));
	}
```

As seen in this test case, the expected value for `customer.getName()` is `Name`,
which is the default **convention** for String bean properties.

Let's take a look a some more conventions.

# Common Conventions

Here's a quick list of conventions for common types:

