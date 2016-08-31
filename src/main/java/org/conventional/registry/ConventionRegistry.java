package org.conventional.registry;

import org.conventional.conventions.Convention;

public interface ConventionRegistry {

	<T> void registerConventionForType(Class<T> returnType, Convention<T> convention);

	<T> Convention<T> getConventionForType(Class<T> returnType);

	boolean isConventionRegisteredForType(Class<?> returnType);

}