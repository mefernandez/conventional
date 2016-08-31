package org.conventional;

import java.math.BigDecimal;

import org.conventional.conventions.FixedValueForTypeConvention;
import org.conventional.conventions.MethodNameLengthConvention;
import org.conventional.conventions.MethodNameStringConvention;

public class DefaultConventionRegistry extends BaseConventionRegistry {

	public DefaultConventionRegistry() {
		registry.put(String.class, new MethodNameStringConvention());
		// FIXME ints are never null, so method interceptor will never lookup this convention
		registry.put(int.class, new MethodNameLengthConvention());
		registry.put(BigDecimal.class, new FixedValueForTypeConvention());
	}
}
