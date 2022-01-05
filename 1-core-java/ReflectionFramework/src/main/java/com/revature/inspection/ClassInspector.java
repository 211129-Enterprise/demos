package com.revature.inspection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * This class will contain a bunch of methods which have the ability 
 * to inspect the methods & properties of another class.
 * 
 * This is a process called Introspection...this is only possible by calling
 * methods from the java.lang.reflect package.
 * 
 * Reflection is a feature in the Java programming language which allows the executing 
 * program to examine or "introspect" upon itself.
 *
 */
public class ClassInspector {
	
	
	public static void listPublicConstructor(Class<?> clazz) {
		
		System.out.println("Printing the public constructors of class " + clazz.getName());
		// build an array of the constructors that belong to a class
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> constructor : constructors) {
			
			// print out the name of the constructor and the parameter types
			System.out.println("\tConstructor name: " + constructor.getName());
			System.out.println("\tConstructor param types: " + Arrays.toString(constructor.getParameterTypes()) + "\n");
			System.out.println();			
		}
	}
	
	public static void listNonPublicFields(Class<?> clazz) {
		
		System.out.println("Printing the non-public fields of class " + clazz.getName());
		Field[] fields = clazz.getDeclaredFields();
		// check that there ARE any declared fields
		if (fields.length == 0) {
			System.out.println("\nThere are no non-public fields in " + clazz.getName());
		}
		
		for (Field field : fields) {
			if ((field.getModifiers() == (Modifier.PUBLIC))) {
				continue;
			}
			// as long as the field is NOT public, we do the following
			System.out.println("\tField name: " + field.getName());
			System.out.println("\tField type: " + field.getType());
			System.out.println("\tIs the field primitive? " + field.getType().isPrimitive());
			System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()));
			System.out.println();
		}

	}
	
	public static void listPublicMethods(Class<?> clazz) {
		System.out.println("Printing public methods of " + clazz.getName());
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods) {
			// exclude all methods from the Object class
			
			if (method.getDeclaringClass() == Object.class) {
				continue;
			}
			
			// make sure you're checking that the modifier is NOT public
			if (!(method.getModifiers() == (Modifier.PUBLIC))) {
				continue;
			}
			
			System.out.println("\nMethod name: " + method.getName());
			System.out.println("\nMethod param count: " + method.getParameterCount());
			System.out.println("\nMethod declared class: " + method.getDeclaringClass());
			System.out.println("\nMethod declared annotations: " + Arrays.toString(method.getDeclaredAnnotations()));
			
			Parameter[] params = method.getParameters();
			for (Parameter param : params) {
				
				// list name, type
				System.out.println("\n\tParameter name: " + param.getName());
				System.out.println("\n\tParameter type: " + param.getType());
			}
		}
		System.out.println();
	}

}