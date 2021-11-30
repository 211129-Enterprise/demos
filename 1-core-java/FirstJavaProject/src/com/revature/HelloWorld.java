package com.revature;

public class HelloWorld {
	
	//ctrl + spacebar allows us to shortcut method signatures
	public static void main(String[] args) {
	
		//syso + ctrl + space
		System.out.println("Hello World from the IDE!");
		
		/**
		 * Java has 8 primitive types
		 * */
		boolean isCool = true; //1 bit of memory (0 or 1) the represents true or false values
		byte reallySmallNumber = 127; //8bits (1 byte) of memory reserved. max 127, min -128
		short shortNumber = 32432; //16 bits of memory
		char letter = 'm'; //16 bits of memory that represents a character or num value of rn ASCII character
		
		int standardNum = 10_000_000; //32 bits of memory
		
		double decimal = 20.45; //64 bits of memory
		float lessPreciseDouble = 93.2f; //32 bits of memory
		
		long bigNumber = 1234567L; //64 bits
	
		/**
		 * Casting
		 * Java is statically typed. Once you assign a type, you can't reassign it
		 * Type casting is used to convert object or variables of one type into another
		 * 
		 * Widening Casting (Implicit)
		 * - Automatic type conversion 
		 * - widening a small value to a larger primitive type
		 * 
		 * Narrow Casting (Explicit)
		 * - Need for manual conversion
		 * - Narrowing a bigger primitive value to a small primitive value
		 * */

		byte a = 40;
		short b = a; //b == 40;
		long bigNum = a;
		
		//we know a double is larger than an int
		double dub = 900.9;
		int myInt = (int) dub;
	
		System.out.println("The narrow casted dub to an int is " + myInt);
		int x = 30;
		int y = -10;
		
		//String is a class, not a primitive type
		String name = "Spongebob"; //This is a String literal
		System.out.println(name + " is " + (x + y) + " years old.");
		//More on String API later...
		
		/**
		 * Wrapper Classes
		 * A Wrapper Class is the class name of the data type
		 * 
		 * Why do we use Wrapper Classes?
		 * Because there are data structures within Java (Specifically the Collections Framework) 
		 * that only store objects
		 * 
		 * What is an Object?
		 * An Object is a re-usable component consisting of properties and methods 
		 * which we can call throughout an application.
		 * These methods and properties are defined within a class.
		 * */
		
		int min = Integer.MIN_VALUE;
		System.out.println("The mininum value of an integer is equal to: " + min);
		
		//Here we convert a primitive datatype into an Integer object
		Integer obj1 = new Integer(20);//This is called AUTOBOXING
		Integer obj2 = new Integer("20");
		
		//Are the above objects the same objects created in memory?
		System.out.println("Are the above objects the same objects created in memory? " + (obj1 == obj2)); // == tests the address in memory
		//Are the 2 objects equal?
		System.out.println("Are the above objects of equal value? " + (obj1.equals(obj2)));
		
		//List is an Interface (defines functionality) and ArrayList is the implementation class
		List<Integer> intList = new ArrayList<Integer>();
		
		
		
	}
}
