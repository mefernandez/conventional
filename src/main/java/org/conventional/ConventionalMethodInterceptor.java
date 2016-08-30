package org.conventional;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ConventionalMethodInterceptor<T> implements MethodInterceptor {
	
	DefaultValueObjectProvider defaultValueObjectProvider;

	private final T original;

	public ConventionalMethodInterceptor() {
		this(null);
	}

	public ConventionalMethodInterceptor(T original) {
		this(original, null);
	}

	public ConventionalMethodInterceptor(T original, DefaultValueObjectProvider defaultValueObjectProvider) {
		this.original = original;
		this.defaultValueObjectProvider = defaultValueObjectProvider != null ? defaultValueObjectProvider : new StaticValueObjectProvider();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
	    throws Throwable {
		
		Object originalValue = null;
		if (original == null) {
			originalValue = proxy.invokeSuper(obj, args);
		} else {
			originalValue = proxy.invoke(original, args);
		}
		
		Class<?> returnType = method.getReturnType();
		
		if (originalValue == null) {
			Object defaultValue = defaultValueObjectProvider.getDefaultValueObject(method);
			if (defaultValue != null) {
				return defaultValue;
			}
			return Conventional.create(returnType);
		}
		
		if (defaultValueObjectProvider.isDefaultValueRegisteredForType(returnType)) {
			return originalValue;
		}
		
		
		return Conventional.wrap(originalValue);
	}

	public DefaultValueObjectProvider getDefaultValueObjectProvider() {
		return defaultValueObjectProvider;
	}

	public void setDefaultValueObjectProvider(DefaultValueObjectProvider defaultValueObjectProvider) {
		this.defaultValueObjectProvider = defaultValueObjectProvider;
	}

}