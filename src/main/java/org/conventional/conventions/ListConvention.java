package org.conventional.conventions;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.conventional.Conventional;
import org.conventional.TestData;

/**
 * Returns the method name, without "get" prefix.
 * @author mefernandez
 *
 */
public class ListConvention implements Convention<List<?>> {

	/**
	 * Credit to:  Mahmoud Ben Hassine.
	 * @see http://www.beyondjava.net/blog/type-erasure-revisited/
	 */
	@SuppressWarnings("unchecked")
	public List<?> createValue(Method method) {
		// Get declared fields
		Field nickNamesField = null;
		try {
			nickNamesField = TestData.class.getDeclaredField("list");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 
		// Get the "nickNames" field which is of type java.util.List<String>
		System.out.println("field name = " + nickNamesField.getName()); 
		// nickNames
		System.out.println("field type : " + nickNamesField.getType()); 
		// interface java.util.List
		 
		Type genericType = nickNamesField.getGenericType();
		System.out.println("field genericType = " + genericType);
		// java.util.List<java.lang.String>
		 
		ParameterizedType parameterizedType = (ParameterizedType) genericType;
		 
		// Get the actual types (this is an array because 
		// there could be multiple types, think of MyType<I, O, R> for example)
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		 
		// Get the actual type
		Type actualTypeArgument = actualTypeArguments[0];
		System.out.println("actualTypeArgument = " + actualTypeArgument);
		// class java.lang.String
		 
		
		
		@SuppressWarnings("rawtypes")
		ArrayList arrayList = new ArrayList();
		Class<?> forName;
		try {
			forName = Class.forName(actualTypeArgument.getTypeName());
			Object element = Conventional.create(forName);
			arrayList.add(element);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

}
