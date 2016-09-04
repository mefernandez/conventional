package org.conventional;

import java.math.BigDecimal;
import java.util.List;

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
	
	List<TestData> list;
	

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

	public List<TestData> getList() {
		return list;
	}

	public void setList(List<TestData> list) {
		this.list = list;
	}
	
	

}
