package com.revature;

public class HelloWorld {

	// ctrl + spacebar allows me to shortcut method signatures
	public static void main(String[] args) {
		
		// sysout + ctrl + space
		System.out.println("Hellow World...from the IDE");

		
		/**
		 * * This is a multi-line
		 * comment.
		 * 
		 * Java has 8 Primitive Types
		 */
		
		// 8 bits = 1 byte
		boolean isCool = true; //1 bit of memory (0 or a 1) that represents true or false values
		byte reallySmallNumber = 127; // 8 bits (1 byte) of memory reserved - max = 127, min = -128
		short shortNumber = 32432; // 16 bits of reserved memory
		char letter = 'm'; // 16 bits of memory that represents a character or the numerical value of an ASCII character
		
		int standardNum = 10_000_000; // 32 bits of memory (4 bytes)
		
		float lessPreciseDouble = 93.2f; // 32 bits of memory
		double decimal = 20.45; // 64 bits of reserved memory
		
		long bigNumber = 1234567L; // 64 bits of reserved memory
	
		/** 
		 * Casting
		 * 
		 * Type casting is used to convert object or variables of one type into another
		 * 
		 * Widening Casting (Implicit) -- Automatic type conversion - widening
		 * a smaller value to a larger primitive type
		 * 
		 * Narrow Casting (Explicit) -- Need for manual conversion - Narrowing a bigger primitive
		 * value to a small primitive value.
		 */
		
		byte a = 40;
		short b = a; // b == 40
		long bigNum = a;
		
		// a double is larger than an int
		double dub = 900.9;
		int myInt = (int) dub;
		
		System.out.println("The narrow (explicit) casted dub to an int is " + myInt);
		
		// String is a class, not a primitive type
		String name = "Spongebob"; // this is a String Literal
		
	
		int x = 30;
		int y = -10;
	
		//Later we will talk about the String API
		System.out.println(name + " is " + (x % y) + " years old");
	
		/**
		 * Wrapper Classes
		 * 
		 * A Wrapper Class is the class name of the data type
		 * 
		 * Why do we use Wrapper Classes?
		 * 
		 * Because there are Data Structures within Java (specifically the Collections Framework)
		 * that only store Objects.
		 * 
		 * What is an Object?
		 * 
		 * An object is a reusable component consisting of properties and methods which
		 * we can call throughout an application.
		 * These methods & properties are defined within a class.
		 * 
		 */
		
		int min = Integer.MIN_VALUE;
		System.out.println("The minimum value of an integer is equal to... " + min);
		
		// Here I am converting a primitive datatype into an Integer Object
		Integer obj1 = new Integer(20); //This is called AUTOBOXING
		Integer obj2 = new Integer("20"); // because we used the new keyword we instantiated a new object
		
		// Are the above objects the same objects created in memory?
		System.out.println("Are the above objects the same objects created in memory? " + (obj1 == obj2)); // == tests address in memory
		
		// are the 2 objects equal?
		System.out.println("Are the above objects of equal value? " + (obj1.equals(obj2))); //== tests address in memory
		
		
		
	}

}
