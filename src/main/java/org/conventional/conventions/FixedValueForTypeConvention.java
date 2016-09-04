package org.conventional.conventions;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Returns fixed values for important types, like "" for String, and so on.
 * @author mefernandez
 *
 */
public class FixedValueForTypeConvention implements Convention<Object> {

	private Map<Class<?>, Object> registry = new HashMap<Class<?>, Object>();
	
	public FixedValueForTypeConvention() {
		// Primitive Types
		
		registry.put(char.class, '\u0000');
		registry.put(long.class, 0L);
		registry.put(int.class, 0);
		registry.put(boolean.class, false);
		registry.put(float.class, 0f);
		registry.put(double.class, 0d);
		
		// Some important Classes
		registry.put(String.class, "");
		registry.put(Long.class, new Long(0L));
		registry.put(Integer.class, new Integer(0));
		registry.put(Boolean.class, new Boolean(false));
		registry.put(Date.class, new Date(0L));
		registry.put(BigDecimal.class, new BigDecimal(0));
		registry.put(BigInteger.class, new BigInteger("0"));
		
		// Collections
		registry.put(List.class, new ArrayList<Object>());
		
	}

	public Object createValue(Method method) {
		Class<?> returnType = method.getReturnType();
		return registry.get(returnType);
	}

	public <T> void registerValueForType(Class<T> returnType, T value) {
		registry.put(returnType, value);
	}

	public boolean isValueRegisteredForType(Class<?> returnType) {
		return registry.containsKey(returnType);
	}

}
