package org.conventional.conventions;

import java.lang.reflect.Method;

/**
 * Returns the method name, without "get" prefix.
 * @author mefernandez
 *
 */
public class MethodNameConvention implements Convention<String> {

	public String createValue(Method method) {
		return method.getName().replaceFirst("^get", "");
	}

}
