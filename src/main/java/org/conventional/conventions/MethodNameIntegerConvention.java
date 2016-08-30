package org.conventional.conventions;

import java.lang.reflect.Method;

/**
 * Returns the method name's length as a number.
 * @author mariano
 *
 */
public class MethodNameIntegerConvention implements Convention<Integer> {

	public Integer createValue(Method method) {
		return method.getName().length();
	}

}
