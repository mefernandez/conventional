package org.conventional.registry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.conventional.Conventional;
import org.conventional.conventions.FixedValueForTypeConvention;
import org.conventional.conventions.ListConvention;
import org.conventional.conventions.MethodNameLengthConvention;
import org.conventional.conventions.MethodNameConvention;

/**
 *Populates a registry with common conventions.
 * @author mariano
 *
 */
public class DefaultConventionRegistry extends BaseConventionRegistry {

	public DefaultConventionRegistry() {
		registry.put(String.class, new MethodNameConvention());
		// FIXME ints are never null, so method interceptor will never lookup this convention
		registry.put(int.class, new MethodNameLengthConvention());
		registry.put(BigDecimal.class, new FixedValueForTypeConvention());
		registry.put(List.class, new ListConvention());
	}
}
