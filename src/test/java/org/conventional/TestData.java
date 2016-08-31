package org.conventional;

import java.math.BigDecimal;

/**
 * Just a class to hold all different property types
 * to test conventions on it.
 * @author mefernandez
 *
 */
public class TestData {
	
	String string;
	int primitiveInt;
	BigDecimal bigDecimal;
	
	TestData testData;
	

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getPrimitiveInt() {
		return primitiveInt;
	}

	public void setPrimitiveInt(int primitiveInt) {
		this.primitiveInt = primitiveInt;
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}

	public TestData getTestData() {
		return testData;
	}

	public void setTestData(TestData testData) {
		this.testData = testData;
	}
	
	

}
