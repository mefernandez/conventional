package org.conventional.registry;

import org.conventional.conventions.Convention;
import org.conventional.conventions.FixedValueForTypeConvention;

public class FixedValueConventionRegistry implements ConventionRegistry {
	
	FixedValueForTypeConvention convention = new FixedValueForTypeConvention();

	public <T> void registerConventionForType(Class<T> returnType, Convention<T> convention) {
		throw new UnsupportedOperationException("This class delegates to a single convention implemented by " + convention.getClass().getName());
	}

	@SuppressWarnings("unchecked")
	public <T> Convention<T> getConventionForType(Class<T> returnType) {
		return (Convention<T>) convention;
	}

	public boolean isConventionRegisteredForType(Class<?> returnType) {
		return convention.isValueRegisteredForType(returnType);
	}

}
