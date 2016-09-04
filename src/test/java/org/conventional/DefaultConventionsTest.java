package org.conventional;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultConventionsTest {

	@Test
	public void testString() {
		TestData data = Conventional.create(TestData.class);
		assertEquals("String", data.getString());
	}

	@Test
	public void testBigDecimal() {
		TestData data = Conventional.create(TestData.class);
		assertEquals("0", data.getBigDecimal().toPlainString());
	}

	@Test
	public void testNestedObject() {
		TestData data = Conventional.create(TestData.class);
		assertNotNull(data.getTestData());
	}

	@Test
	public void testNestedObjectString() {
		TestData data = Conventional.create(TestData.class);
		assertEquals("String", data.getTestData().getString());
	}

	@Test
	public void testList() {
		TestData data = Conventional.create(TestData.class);
		assertNotNull(data.getList());
	}

	@Test
	public void testListIsNotEmpty() {
		TestData data = Conventional.create(TestData.class);
		assertFalse(data.getList().isEmpty());
	}

	@Test
	public void testListFirstElement() {
		TestData data = Conventional.create(TestData.class);
		assertEquals("String", data.getList().get(0).getString());
	}
}
