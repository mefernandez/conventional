package org.conventional.conventions;

import java.lang.reflect.Method;

/**
 * Returns the method name.
 * @author mariano
 *
 */
public class MethodNameStringConvention implements Convention<String> {

	public String createValue(Method method) {
		return method.getName().replaceFirst("get", "");
	}

}
