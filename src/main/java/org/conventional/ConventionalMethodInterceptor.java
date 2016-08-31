package org.conventional;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.conventional.conventions.Convention;
import org.conventional.registry.BaseConventionRegistry;
import org.conventional.registry.ConventionRegistry;
import org.conventional.registry.DefaultConventionRegistry;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Intercepts method calls and creates new objects if method returns null.
 * @author mefernandez
 *
 * @param <T>
 */
public class ConventionalMethodInterceptor<T> implements MethodInterceptor {
	
	ConventionRegistry registry;

	private final T original;

	public ConventionalMethodInterceptor() {
		this(null);
	}

	public ConventionalMethodInterceptor(T original) {
		this(original, null);
	}

	public ConventionalMethodInterceptor(T original, ConventionRegistry registry) {
		this.original = original;
		this.registry = registry != null ? registry : new DefaultConventionRegistry();
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
			Convention<?> convention = registry.getConventionForType(returnType);
			if (convention != null) {
				return convention.createValue(method);
			}
			return Conventional.create(returnType);
		}
		
		if (registry.isConventionRegisteredForType(returnType)) {
			return originalValue;
		}
		
		
		return Conventional.wrap(originalValue);
	}

	public ConventionRegistry getDefaultValueObjectProvider() {
		return registry;
	}

	public void setDefaultValueObjectProvider(BaseConventionRegistry defaultValueObjectProvider) {
		this.registry = defaultValueObjectProvider;
	}

}