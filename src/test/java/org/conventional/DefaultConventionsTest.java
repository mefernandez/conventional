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
}
