package com.revature;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World... from the IDE");
		
		boolean isCool = true; // 1 bit represents true or false value (either 0 or 1) 
		byte reallySmallNumber = 127; // 8 bits (1 byte) of reserved memory -> max value is 127, min value -128.
		short shortNumber = 32767; // 16 (2 bytes) bits of reserved mem
		char letter = 'm'; // 16 bits of memory that represent a character or an ASCII character's numeric
							// value
		int standardNum = 10_000_000; // 32 bits of reserve mem (4 bytes)
		float lessPreciseDouble = 93.2f; // 32 bits of mem, allows you to make decimals, but it's-- less precise than a
											// double
		double decimal = 20.45; // 64 bits of mem (8 bytes)
		long bigNumber = 12345678L; // 64 bits
		
		/*
		 * Casting
		 * 
		 * Type casting is used to convert objects or variables of one type into another
		 * 
		 * Widening Casting (Implicit) -- Automatic Type Conversion Widening a smaller
		 * primitive value to a bigger primitive type.
		 * 
		 * Narrowing Casting (Explicit) -- Need Explicit Conversion with () Narrowing a
		 * bigger primitive value to a small primitive value.
		 */

		byte a = 40;
		short b = a; // b == 40. a short has more reserved memory than a byte, so we can easily convert a byte to a short.

		// byte anotherByte = b; // This isn't IMPLICITLY converted! We need to use
		// casting for this. More on that in a bit.
		int c = b;
		double d = c;
	
		// a double is larger than an integer
		double dub = 900.9;
		int myInt = (int) dub; // we are using NARROW Casting to transform a large datatype to a small one
		
		System.out.println("the double that has been explicitly cast to an int is now equal to " + myInt);
		
		int x = 4;
		int y = 10;
		
		System.out.println(x + y);
		String name = "Spongebob";
		
		System.out.println(name + " is " + (x + y * 100) + " years old");
		int min; // Variable Declaration =- declaring the type
		min = Integer.MIN_VALUE;
		
		// Question 1: do obj1 & obj 2 have the same value?
				System.out.println(obj1.equals(obj2)); // alt + shift + x, j -> YES they have the same value
				
				// Question 2: do obj1 & obj2 point to the same object in the heap?
				System.out.println("testing the ==" + (obj1 == obj2)); // FALSE!  the == checks for address in memory
				
				// Unboxing: object -> primitive type
				
				// Challenge: Convert the following Double Object to a primitive double:
				Double dubObj = 15.45; // we are instantiating a Double object that has the value of the initialized primitve literal.
				Double dubObj2 = new Double(76.123);
				// convert that to a double....
				double dubPrimitive = dubObj; // implicit way of transofrming it
				
				double dubPrimitive2 = Double.valueOf(dubObj); // explicut
				
				dubObj2 = null;

				// if I were to do something with
				List<Double> dubList = new ArrayList<Double>();
				
				// ctrl + shift + o to auto import everything
				dubList.add(dubObj);
				dubList.add(dubObj2);
				
				/**
				 * Wrapper Classes
				 * Unboxing
				 * Autoboxing
				 * 
				 * == vs. .equals();
				 */
	}
}
