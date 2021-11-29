package com.revature;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	// CTRL + Spacebar allows shortcut
	public static void main(String[] args) {
		
		// sysout + CTRL Spacebar
		System.out.println("Hello World... From the IDE!");
		
		/**
		 * This is a multi-line comment.
		 * it goes through multiple lines.
		 * 
		 * 
		 * java has 8 Primitive Types:
		 * 
		 * 
		 * Even to here!
		 */
		
		// 8 bit = 1 byte
		boolean isCool = true; // 1 bit of memory (0 or 1) that represents a true or false value
		byte reallySmallNumber = 127; // 8 bits (1byte) of memory reserved.  max 127, min -128
		short shortNumber = 32432; // 16 bits of reserved memory.
		char letter = 'm'; // 16 bits of memory that represents a character or the numerical value of an ASCII character
		// char letterNumber = 109; char can take directa ASCII value.
		
		int standardNumber = 10_000_000; // 32 bits of memory (4 bytes)
		
		float lessPreciseDecimal = 93.2f; // 32 bit s of memory
		double decimal = 20.45; // 64 bits of reserved memory
	
		long bigNumber = 1234567L; // 64 bits of memory, no decimal places.
		
		/**
		 * Casting
		 * 
		 * Type casting is used to convert object or variables of one type into another
		 *
		 * Widening Casting (Implicit) -- Automatic type conversion - widening a smaller value to a larger primitive type.
		 * 
		 * Narrow Casting (Explicit) -- Need for manual conversion - Narrowing a bigger primitive value to a smaller one.
		 * 
		 * 
		 * 
		 */
		
		byte a = 40;
		short b = a; // b == 40
		long bigNum = a;
		
		// a double is larger than an int
		
		double dub = 900.9;
		int myInt = (int) dub;
		System.out.println("the narrow (explicit) casting of dub containing 900.9 to an int is: " + myInt);
		
		// String is a class, not a primitive type.
		String name = "testName";
		
		int x = 30;
		int y = -10;

		
		// Later we will talk about the String API
		
		System.out.println(name + "is" + (x+y) + "years old.");
		
		/**
		 * Wrapper Classes
		 * 
		 * A Wrapper Class is the class name of the data type
		 * 
		 * Because there are Data Structures within Java (Specifically the Collections Framework) that only store Objects
		 * 
		 * What is an Object?
		 * 
		 * An Object is a re-usable component consisting of properties and methods which we can call throughout an application.
		 * 
		 * A class is a blueprint of an Object. The methods and properties are defined within the class.
		 * 
		 * 
		 */
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		System.out.println("The minimum value of an int = " + min);
		System.out.println("The maximum value of an int = " + max);
		
		// Here I am converting a primitive datatype into an Integer Object
		Integer obj1 = new Integer(20); // This is called AUTOBOXING the reverse is AUTO-UNBOXING
		Integer obj2 = new Integer("20"); // Because we used the new keyword we Instatiated a new Object
		
		// Are the above objects the same objects created in memory?
		
		System.out.println("Are the above objects the same objects created in memory? " + (obj1 == obj2));
		
		// are the 2 objects equal?
		
		System.out.println("Are the above objects of equal value? " + (obj1.equals(obj2)));
		
		// List is an interface (defines functionality) and ArrayList is the implementation class
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(obj1);
		intList.add(100); // This will automatically be autoboxed because teh arraylist only stores objects of integer type.
		
		int prim = Integer.valueOf(intList.get(0)); // auto-unboxing example
		
		System.out.println(prim);
		
		/**
		 * Unboxing
		 * Autoboxing
		 * the 8 Java primitives
		 */
	
		
		
	}
	
}
