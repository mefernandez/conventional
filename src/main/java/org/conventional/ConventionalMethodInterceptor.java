package org.conventional;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.conventional.conventions.Convention;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ConventionalMethodInterceptor<T> implements MethodInterceptor {
	
	ConventionRegistry defaultValueObjectProvider;

	private final T original;

	public ConventionalMethodInterceptor() {
		this(null);
	}

	public ConventionalMethodInterceptor(T original) {
		this(original, null);
	}

	public ConventionalMethodInterceptor(T original, ConventionRegistry defaultValueObjectProvider) {
		this.original = original;
		this.defaultValueObjectProvider = defaultValueObjectProvider != null ? defaultValueObjectProvider : new DefaultConventionRegistry();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		Object originalValue = null;
		if (original == null) {
			originalValue = proxy.invokeSuper(obj, args);
		} else {
			originalValue = proxy.invoke(original, args);
		}
		
		Class<?> returnType = method.getReturnType();
		
		if (originalValue == null) {
			Convention<?> convention = defaultValueObjectProvider.getConventionForType(returnType);
			if (convention != null) {
				return convention.createValue(method);
			}
			return Conventional.create(returnType);
		}
		
		if (defaultValueObjectProvider.isConventionRegisteredForType(returnType)) {
			return originalValue;
		}
		
		
		return Conventional.wrap(originalValue);
	}

	public ConventionRegistry getDefaultValueObjectProvider() {
		return defaultValueObjectProvider;
	}

	public void setDefaultValueObjectProvider(BaseConventionRegistry defaultValueObjectProvider) {
		this.defaultValueObjectProvider = defaultValueObjectProvider;
	}

}