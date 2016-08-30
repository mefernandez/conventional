# Conventional (a.k.a POJOnes)
Populate POJOs with dummy data based on conventions to make unit testing easier.

# Show me how

Consider this example of domain model regarding a `Customer` and its `Orders`:

![Domain model](http://yuml.me/d1ee20df)

Let's say you want to do some unit testing and we need a fully populated `Customer`.
You can do it manually:

```java
// Set up test data
Customer customer = new Customer();
customer.setName("John Doe");
Address address = new Address();
address.setStreet("21B Baker Street");
Order order = new Order();
LineItem item = new Item();
item.setQuantity(10);
item.setPrice(new BigDecimal("1.05"));
order.addLineItem(item);
```

That's quite verbose!

How about this instead?

Conventional.forClass(Customer.class);
[Customer|name:String]<>-orders*>[Order|total:price], [Order]++-0..*>[LineItem|quantity:int;price:BigDecimal], [Customer]-[Address|street:String]
