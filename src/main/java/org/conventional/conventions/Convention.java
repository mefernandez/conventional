package org.conventional.conventions;

import java.lang.reflect.Method;

/**
 * An interface to define conventions to return some value for type T.
 * 
 * @author mefernandez
 *
 * @param <T>
 */
public interface Convention<T> {
	
	public T createValue(Method method);

}
