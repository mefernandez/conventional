package org.conventional.conventions;

import java.lang.reflect.Method;

/**
 * Returns the method name's length as a number.
 * @author mefernandez
 *
 */
public class MethodNameLengthConvention implements Convention<Integer> {

	public Integer createValue(Method method) {
		return method.getName().length();
	}

}
