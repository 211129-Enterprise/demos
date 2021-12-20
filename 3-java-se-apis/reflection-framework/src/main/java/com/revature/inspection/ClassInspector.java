package com.revature.inspection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/*
 * This class will contain a bunch of methods which
 * have the ability to inspect the methods and properties
 * of another class.
 * 
 * This is a process called INTROSPECTION.
 * This is only possible by calling methods from the
 * java.lang.reflect package.
 * 
 * Reflection is a feature in the Java programming language which
 * allows the executing program to examine, or "introspect" upon itself.
 */
public class ClassInspector {

	public static void listPublicConstructor(Class<?> clazz) {
		
		System.out.println("Printing the public constructors of class " + clazz.getName());
		
		// Could build an array of constructors that belong to a class
		Constructor<?>[] constructors = clazz.getConstructors();
		
		for(Constructor<?> constructor : constructors) {
			
			// print out the name of the constructor and the parameter types
			System.out.println("\tConstructor name: " + constructor.getName());
			System.out.println("\tConstructor param types: " + Arrays.toString(constructor.getParameterTypes()) + "\n\n");
		}
		System.out.println("\n");
	}
	
	
	public static void listNonPublicFields(Class<?> clazz) {
		
		System.out.println("Printing the non-public fields of the " + clazz.getName());
		
		Field[] fields = clazz.getDeclaredFields();
		
		// Check that there ARE any declared fields
		if( fields.length == 0) {
			System.out.println("\nThere are no non-public fields in " + clazz.getName());
		}
		

		for(Field field : fields) {
			
			if( !(field.getModifiers() == (Modifier.PUBLIC)) ) {
				continue;
			}
			
			// As long as the field is NOT public, we do the following...
			System.out.println( "\tField name: " + field.getName() );
			System.out.println( "\tField type: " + field.getType() );
			System.out.println( "\tIs Field Primitive? " + field.getType().isPrimitive() );
			System.out.println( "\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()) );
			System.out.println();
		}
		
	}
	
	
	public static void listPublicMethods(Class<?> clazz) {
		
		System.out.println( "Printing public methods of " + clazz.getName() );
		Method[] methods = clazz.getMethods();
		
		for(Method method : methods) {
			
			// Exclude all methods from the Object class
			if( method.getDeclaringClass() == Object.class ) {
				continue;
			}
			if( !(method.getModifiers() == (Modifier.PUBLIC)) ) {
				continue;
			}
			
			System.out.println( "\tMethod Name: " + method.getName() );
			System.out.println( "\tMethod Param Count: " + method.getParameterCount() );
			System.out.println( "\tMethod Declared Class: " + method.getDeclaringClass() );
			System.out.println( "\tMethod Delared Annotations: " + Arrays.toString(method.getDeclaredAnnotations()) );
			
			Parameter[] params = method.getParameters();
			for(Parameter param : params ) {
				
				//List name and type
				System.out.println( "\n\tParameter name: " + param.getName() );
				System.out.println( "\n\tParameter type: " + param.getType() );
			}
				
		}
		System.out.println();
		
	}
}
