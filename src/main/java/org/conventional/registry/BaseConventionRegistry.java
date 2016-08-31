package org.conventional;

import java.util.HashMap;
import java.util.Map;

import org.conventional.conventions.Convention;

public class BaseConventionRegistry implements ConventionRegistry {

	protected Map<Class<?>, Convention<?>> registry = new HashMap<Class<?>, Convention<?>>();
	
	public <T> void registerConventionForType(Class<T> returnType, Convention<T> convention) {
		registry.put(returnType, convention);
	}

	@SuppressWarnings("unchecked")
	public <T> Convention<T> getConventionForType(Class<T> returnType) {
		return (Convention<T>) registry.get(returnType);
	}

	public boolean isConventionRegisteredForType(Class<?> returnType) {
		return registry.containsKey(returnType);
	}

}
