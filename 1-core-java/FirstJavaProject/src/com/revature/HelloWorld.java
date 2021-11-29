package com.revature;

public class HelloWorld {
	
	// ctrl + spacebar allows me to create a shortcut method signature
	public static void main(String[] args) {
		
		//sysout + ctrl + space
		System.out.println("Hello World...from the IDE");
		
		
		/**
		 * Java has 8 primitive types
		 * 
		 * 8 bits = 1 byte
		 * boolean a true or false value. 1 bit of memory
		 * byte 8 bits of memory reserved. max = 127 min =-128
		 * short 16 bits of reserved memory
		 * char is a letter or a symbol. 16 bits of reserved memory. represents the numerical value of the ASCII value of the character
		 * int standard number. Whole numbers only can add underscores to enhance readability. reserves 32 bits of memory or 4 bytes
		 * double 64 bits of reserved memory for decimals
		 * float 32 bits of reserved memory for decimals less precise double
		 * long a large number 64 bits of reserved memory. No decimal places
		 * 
		 * 
		 * 
		 */
		
		/**
		 * Casting
		 * 
		 * Type casting is used to convert object or variables of one type into another
		 * 
		 * widening casting (Implicit) -- automatic type conversion - widening
		 * a smaller value to a larger primitive type
		 * 
		 * Narrow Casting (Explicit) -- Need for manual conversion - narrowing a bigger primitive value
		 * to a small primitive value.
		 */
	
		byte a = 40;
		short b = a; // b == 40
		
		//A string is a class not a primitive type
		
		/**
		 * Wrapper Classes
		 * 
		 * Class names of the primitive date types
		 * 
		 * Why do we use wrapper classes?
		 * There are date structures that only work with objects (specifically the collections framework)
		 * that only stores objects.
		 * 
		 * What is an object?
		 * A re-usable component consisting of properties and methods which
		 * we can call throughout an application
		 * These methods and properties are defined in a class
		 */
		
		
		//Here I am converting a primitive datatype into an Integer Object
		Integer obj1 = new Integer(20); //This is called Autoboxing
		Integer obj2 = new Integer("20");//Because we used the new key word we instantiated a new object
		
		//Are the above objects the same objects created in memory?
		System.out.println("Are the above objects the same objects created in memory? " + (obj1 == obj2)); // == tests address in memory
		
		//are the two objects equal?
		System.out.println("are the above objects of equal value? " + (obj1.equals(obj2))); //test value of the two objects
	}

}
