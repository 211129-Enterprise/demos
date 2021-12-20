package com.revature.inspection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *This class will contain a bunch of method which have the ability 
 *to ispect the methods && properties of another class
 *
 * 
 * this process called ItroSpection 
 * 
 */

public class Inspector {
	
	
	
	public static void listPublicConstructor(Class<?> clazz) {
		
		System.out.println("Printing the public constructor of class "+ clazz.getName());
		
		// build an array of the construtors that  belong to class 
		
		Constructor<?>[] constructors = clazz.getConstructors();
		
		for(Constructor<?> constructor : constructors) {
			System.out.println("\t Construtor name :" + constructor.getName());
			System.out.println("\t Construtor param types :" + Arrays.toString(constructor.getParameters()) + "\n");
			System.out.println();
			
		}
		
	}

	public static void listNonPublicField(Class<?> clazz) {
		System.out.println("We ara printing the non public field of the class " + clazz.getName());
		

	
	Field[] fields = clazz.getDeclaredFields();
	
	List<Field> fieldsList = new ArrayList<>(Arrays.asList(fields));
		
		if(fields.length == 0) {
			System.out.println("\n there are non public fields in "+ clazz.getName());
		}
		
//		fieldsList.stream().filter(f-> ! f.getModifier.equals(Modifier.PUBLIC)).foreach(e->{
//			System.out.println("the field name is equal to :" + e.getName());
//		});
		
		
		for(Field field : fields) {
			if(field.getModifiers() == (java.lang.reflect.Modifier.PUBLIC)) {
				continue;
			}
			System.out.println("field name "+field.getName() );
			
			System.out.println(" field type " + field.getType());
			
			System.out.println("is this field primitive ?" + field.getType().isPrimitive());
			
			System.out.println("Modifier bit value " + Integer.toBinaryString(field.getModifiers()));
			
		}
		
		// as long as the field is not public, we do the following

	}
	
	public static void listPublicMethods(Class<?> clazz) {
		System.out.println("Printing public methods of " + clazz.getName());
		
		Method[] methods = clazz.getMethods();
		
		for(Method method : methods) {
			// exclude all methods from the object class 
			if(method.getDeclaringClass().equals(Object.class)) {
				continue;
			}
			
			if(method.getModifiers() != (java.lang.reflect.Modifier.PUBLIC)) {
				continue;
			}
			
			System.out.println("\n Method name : " + method.getName());
			
			System.out.println("\n Method param count: " + method.getParameterCount());
			
			// important
			
			System.out.println(" \n Method declare class : " + method.getDeclaringClass());
			
			System.out.println("\n Method declared annotations : " + Arrays.toString(method.getDeclaredAnnotations()));
			
			Parameter[] parameters = method.getParameters();
			
			for(Parameter parameter: parameters) {
				System.out.println("\n Parameter name : "+ parameter.getName());
				System.out.println("\n Parameter type : " + parameter.getType());
			}
			
			System.out.println();
			
		}
		
		
		
	}
	
}
