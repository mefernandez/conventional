package org.conventional;

import java.lang.reflect.Method;

public interface DefaultValueObjectProvider {

	Object getDefaultValueObject(Method method);

	boolean isDefaultValueRegisteredForType(Class<?> returnType);

}