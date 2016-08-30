package org.conventional;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommonConventionsTest {

	@Test
	public void testString() {
		TestData data = Conventional.create(TestData.class);
		assertEquals("String", data.getString());
	}

}
