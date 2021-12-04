package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**
 * Strings are used to store a sequence of characters, but they are treated as objects because they come from the STING class
 * 
 * 2 types of string objects
 * 		1. String Object created with the new keyword - stored in heap 
 * 
 * 		2. String literal created with " "  like String word = "something" - goes to the String Pool a special place for strings in the heap
 */
		
		String stringObject = new String("Straight to the general heap we go"); // in the general heap
		
		System.out.println(stringObject);
		
		String str1 = "Hello"; // String literal -> goes to string pool
		String str2 = "Hello"; // here no new String Object is created. JVM checks string pool for matching object containing the exact same pattern of characters in the pool and simply points at it if it does
		
		System.out.println("Does str1 have the same value as str2? " + str1.equals(str2));
		
		System.out.println("Is str1 the same object? " + (str1 == str2));
		
		String stringObject2 = new String("Hello");
		
		System.out.println("Is stringObject2 the same object? " + (str1 == stringObject2));
		
		String str3 = "Hello World";
		String str4 = "Hello" + " World"; // not a mutation 
		System.out.println(str3==str4);
		
		// even though the memory address is different the hash code can be the same, it represents the value itself
		System.out.println(str2.hashCode());
		System.out.println(stringObject2.hashCode());
		
		String str5 = "Hello";
		String str6 = str5 + " World"; // this is a mutation - str6 is sent to the general heap - equivalent of using new keyword to make a string
		
		System.out.println(str6 == str3);
		
		String str6inPool = str6.intern(); // returns a string object that matches the pattern of the non pool object and the reference variable now points to it.
		
		System.out.println(str6inPool == str3); 
		
		
		/**
		 * String API
		 * 
		 * concat()
		 * substring()
		 * charAt()
		 * split()
		 * isEmpty()
		 * Length()
		 * 
		 * 
		 */
		
		String newStrObject = str6inPool.concat("Somegarbage"); // sent to gen heap
		
		System.out.println(newStrObject);
		
		String test = "The quick brown fox jumped over the lazy dog";
		String chopped = test.substring(5);
		System.out.println(chopped);
		
		// These are mutable versions of the String class
		//StringBuffer -- Thread safe and slower
		//StringBuilder	-- NOT Thread save and faster
		
		
		StringBuilder sbuild = new StringBuilder("Hello");
		sbuild.append(" ");
		sbuild.append("World");
		System.out.println("StringBuilder!" + sbuild);
		
		//how do we send this string object to the string pool?
		//1. convert to a String Object
		String buildToString = sbuild.toString(); // in gen heap
		
		String sbInPool = buildToString.intern();
		
		System.out.println(sbInPool);
		System.out.println(sbInPool == str6inPool);
		
		
		
		
				
	}

}
