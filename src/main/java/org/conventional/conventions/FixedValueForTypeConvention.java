package org.conventional.conventions;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Returns fixed values for important types, like "" for String, and so on.
 * @author mefernandez
 *
 */
public class FixedValueForTypeConvention implements Convention<Object> {

	private Map<Class<?>, Object> defaultValuesRegistry = new HashMap<Class<?>, Object>();
	
	public FixedValueForTypeConvention() {
		// Primitive Types
		
		defaultValuesRegistry.put(char.class, '\u0000');
		defaultValuesRegistry.put(long.class, 0L);
		defaultValuesRegistry.put(int.class, 0);
		defaultValuesRegistry.put(boolean.class, false);
		defaultValuesRegistry.put(float.class, 0f);
		defaultValuesRegistry.put(double.class, 0d);
		
		// Some important Classes
		defaultValuesRegistry.put(String.class, "");
		defaultValuesRegistry.put(Long.class, new Long(0L));
		defaultValuesRegistry.put(Integer.class, new Integer(0));
		defaultValuesRegistry.put(Boolean.class, new Boolean(false));
		defaultValuesRegistry.put(Date.class, new Date(0L));
		defaultValuesRegistry.put(BigDecimal.class, new BigDecimal(0));
		defaultValuesRegistry.put(BigInteger.class, new BigInteger("0"));
		
	}

	public Object createValue(Method method) {
		Class<?> returnType = method.getReturnType();
		return defaultValuesRegistry.get(returnType);
	}

	public Map<Class<?>, Object> getDefaultValuesRegistry() {
		return defaultValuesRegistry;
	}

	public void setDefaultValuesRegistry(Map<Class<?>, Object> defaultValuesRegistry) {
		this.defaultValuesRegistry = defaultValuesRegistry;
	}

}
