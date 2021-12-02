package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		/**
		 * Strings are used to store a sequence of characters, but they're treated as objects
		 * .. because they come from the STRING class!
		 * 
		 * - (1) String Object created with the new keyword -> goes to the general heap.
		 * - (2) String literal created with " " like String word = "something". -> goes to the String Pool INSIDE the heap 
		 */

		String stringObject = new String("straight to the general we go"); // in the general heap!
		System.out.println(stringObject);
		
		String str1 = "Hello"; // string literal -> string pool
		String str2 = "Hello"; // here, no new string object is created, the JVM checks if a string object matching this pattern 
		                       // exists in the String Pool
		
		System.out.println("Does str1 have the same value as str2? " + str1.equals(str2)); // true
		
		// do they point to the same location in memory?
		System.out.println("Is str1 the same object as str2? " + (str1 == str2)); // true!
		
		// up to this point only 2 objects have been created!
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode()); 
		
		String stringObject2 = new String("Hello"); // this string object goes to the general heap
		
		// does this mean that StringObject2 points to the same object as str1 & str 2? NO!
		System.out.println(stringObject2 == str2); // false because str3 is in a separate location in memory
		
		String str3 = "Hello World";
		String str4 = "Hello" + " World"; // this is NOT a mutation
		System.out.println(str3 == str4); // true because + is smart
		
		// even though the memory address is different remember that hashCode is NOT the address in memory!
		System.out.println(stringObject2.hashCode());
		System.out.println(str2.hashCode()); // represents b value of the objects properties (state)
		
		String str5 = "Hello";
		String str6 = str5 + " World"; // this is a mutation - str6 is sent to the general heap - this is the equivalent of String str6 = new String()
		System.out.println(str6 == str3);
		
		// let's send str 6 to the string pool
		String str6inPool = str6.intern(); // this returns a string object that matches the pattern of the general heap object 
										   // and this reference variable now points to it
		
		System.out.println(str6inPool == str3);
		
		/**
		 * String API
		 * 
		 * - concat()
		 * - substring()
		 * - charAt()
		 * - split()
		 * - isEmpty()
		 * - length()
		 */
		
		String newStrObject = str6inPool.concat("Somegarbage"); // sent to general heap
		System.out.println(newStrObject);
		
		String test = "The quick brown fox jumped over the lazy dog";
		String chopped = test.substring(5);
		System.out.println(chopped);
		
		// These are mutable versions of the String class
		// StringBuffer - thread safe and slower
		// StringBuilder - NOT thread safe and faster
		
		
		StringBuilder sbuild = new StringBuilder("Hello");
		sbuild.append(" ");
		sbuild.append("World"); // the same object has been mutated
		
		System.out.println("StringBuilder! " + sbuild);
		
		// how do we send this string object to the string pool
		// 1. convert to a string object (from the String class)
		String buildToString = sbuild.toString(); // in general heap
		
		// to the string pool!
		String sbInPool = buildToString.intern(); // now it's in the String pool!
		System.out.println(sbInPool == str6inPool); // true
	}
	
	public void sillyInterviewQ() {
		// Java literal 
		String str1 = "Hello"; // string literal -> string pool
		String str2 = "Hello"; // here, no new string object is created, the JVM checks if a string object matching  
		                       // this pattern exists in the String Pool
		String str3 = "Hell01"; // would be a totally different object 		
	}

}