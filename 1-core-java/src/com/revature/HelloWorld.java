package com.revature;

import java.util.*;

import com.revature.garbagecollection.Garbage;

public class HelloWorld {
	//ctrl + spacebar allows me to shortcut method signature
	public static void main(String[] args) {
		//sysout + ctl + space
		System.out.println("Hellow World... from IDE");
		/**
		 * Java has 8 primitive types
		 * 
		 */
		boolean isCool = true; //1 bit
		byte reallySmall = 127; //8 bits (1 byte) memory reserved max = 127, min = -128
		short shortNumber = 32432;// 16 bits of reserved memory
		char letter = 'm'; // 16bits character or numeric value of ASCII character
		int standardNum = 1_000_000; //32 bits of mem (4 bytes)
		
		float lessPerciseDouble = 4.2f; //32 bits of mem
		double decimal = 20.45; //64bits of reserved memory
		
		long bigNumber = 99999999L; //64bits, no decimals
		
		
		/**
		 *type casting how to change the type
		 *widening casting (Implicit means automatic) 
		 *  Automatic type conversion
		 *  Don't loose anything
		 *Narrow Casting (Explicit)
		 *	Need a manual conversion
		 *  Because you are making the value smaller 
		 */
		byte a = 40;
		short b = a; //no error because its implicit
		
		// a double is larger than an int
		double dub = 900.9;
		int myInt = (int) dub; //have to drop the decimal
		
		System.out.println("Narrow casting (explicit) dub to int" + myInt);
		
		// String is a class, not a primitive type
		String name = "Potato";
		
		int x = 30;
		int y = -10;
		
		System.out.println(name + " is " + (x + y) + " years old");
		
		/** 
		 * Wrapper Classes
		 * 
		 * Class names of the primitive data types
		 * 
		 * Why use them?  There are data structures that only work with objects
		 * The Collections Framework, it only stores objects
		 * 
		 * What is an Object
		 * re-usable component consisting of methods and properties we use throughout the application
		 * 
		 * 
		 */
		
		int min = Integer.MIN_VALUE; //Integer is the 
		System.out.println("The minimum value of an integer is equal to...  " + min);
		
		// how to convert a primitive to an integer object
		// called AUTOBOXING
		Integer obj1 = new Integer(20); //how to make an integer object
		Integer obj2 = new Integer("20");
		
		// are they the same?  FALSE
		System.out.println("Are the above objects the same objects created in memory? " + (obj1 == obj2));
		// are they equal? TRUE
		System.out.println("Are the above objects the same objects created in memory? " + (obj1.equals(obj2)));
		//Integer to primitive AUTOUNBOXING
		
		// List is an interface (Defines functionality) ArrayList is the implementation class
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(obj1);
		intList.add(100); //automatically AUTOBOXES this number when it adds it to the list
		
		int prim = Integer.valueOf(intList.get(0)); //AUTO-UNBOXING
		
		/**
		 * Scanner A way of getting user input from the console
		 * stdin = standard input
		 * stdout = standard output
		 */
		System.out.println("Enter your name bellow: ");
		Scanner scanner = new Scanner(System.in);
		String result = "";
		
		result = scanner.nextLine();
		
		scanner.close();
		
		System.out.println(result + " Likes Potatos");
		
		/*
		 * Unix commands
		 *  
		 */
		
		
		/**
		 * -Wrapper Class
		 * -AUTOUNBOXING
		 * -AUTOBOXING
		 * -PRIMITIVES
		 * -Scanner
		 */
		System.out.println(Garbage.numThatNeverChanges);
	
	}
}
