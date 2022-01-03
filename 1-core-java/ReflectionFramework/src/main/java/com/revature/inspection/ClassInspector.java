package com.revature.inspection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ClassInspector {
	private static void listPublicConstructor(Class<?> clazz) {
		// TODO Auto-generated method stub
		System.out.println("printing the public sontructors of class ");
		
		Constructor<?>[] constructors = clazz.getConstructors();
		
		for (Constructor<?> constructor : constructors) {
			System.out.println("\tConstructor name: " + constructor.getName());
			System.out.println("\tConstructor param types: " + Arrays.toString(constructor.getParameterTypes()) + "\n");
			System.out.println();
		}
	}
	
	public static void listNonPublicFields(Class<?> clazz) {
		System.out.println("Printing the non-public fields class " + clazz.getName());
		
		Field[] fields = clazz.getDeclaredFields();
		
		if (fields.length == 0) {
			System.out.println("\tThere are no non-public fields in " + clazz.getName());	
		}
		
//		List<Field> fieldList = Arrays.asList(fields);
//		
//		fields.stream()
//		.filter(f -> f. !f.getModifer.equals(Modifier.PUBLIC))
//		.forEach(e1 -> {
//			System.out.println("\nField name: " + e1.getName())
//		})
		
		for(Field field : fields) {
			if((field.getModifiers()) == (Modifier.PUBLIC)) {
				continue;
			}
			
			System.out.println("\tField name: " + field.getName());
			System.out.println("\tField type: " + field.getType());
			System.out.println("\tIs the field primitive?" + field.getType().isPrimitive());
			
			System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()));
		}
	}
	
	public static void listPublicMethods(Class<?> clazz) {
		System.out.println("Printing public methods of " + clazz.getName());
		Method[] methods = clazz.getMethods();
		
		for(Method method : methods) {
			if (method.getDeclaringClass() == Object.class) {
				continue;
			}
			
			if (!(method.getModifiers() == (Modifier.PUBLIC))) {
				continue;
			}
			
			System.out.println("\nMethod name: " + method.getName());
			System.out.println("\nMethod param count: " + method.getParameterCount());
			System.out.println("\nMethod declared class " + method.getDeclaringClass());
			System.out.println("\nMethod declared annotation: " + Arrays.toString(method.getAnnotations()));
			
			Parameter[] params = method.getParameters();
			for(Parameter param : params) {
				// list name, type
				System.out.println("\n\tParameter name" + param.getName());
				System.out.println("\n\tParamter type: " + param.getType());
				
			}
		}
		System.out.println();
	}
}
