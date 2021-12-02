package com.revature.strings;

public class Driver {

	public static void main(String[] args) {


		String stringObject = new String("straight to the general heap we go"); // in the general heap!
		System.out.println(stringObject);
		
		String str1 = "Hello"; // string literal -> string pool
		String str2 = "Hello"; // here, no new string is created, the JVM checks if a string object matching this pattern exists in the string pool
		
		System.out.println("Does str1 have the same value as str2? " + str1.equals(str2));
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		String stringObject2 = new String("Hello"); // this string object goes to the normal heap
		
		System.out.println(stringObject2 == str2);
		
		String str3 = "Hello World";
		String str4 = "Hello " + "World";
		System.out.println(str3 == str4);
		
		
		// even though the memory address is defferent, remember that the hashCode is not the address in memory
		System.out.println(stringObject2.hashCode());
		System.out.println(str2.hashCode());

		String str5 = "Hello";
		String str6 = str5 + " World"; // str6 goes to general heap
		System.out.println(str6==str3);
		
		// let's send str6 to the string pool
		String str6inPool = str6.intern();
		System.out.println(str6inPool==str3);
		
		// These are mutable versions of the String class
		// StringBuffer - thread safe and slower
		// StringBuilder - NOT thread safe and faster
		StringBuilder sbuild = new StringBuilder("Hello");
		sbuild.append(" ");
		sbuild.append("World"); // the same object being mutated, i.e. not creating new objects
		
		System.out.println("StringBuilder! " + sbuild);
		// how do we send this string object to the string pool?
		// convert to a string object (from the String class)
		String buildToString = sbuild.toString();
		
		String sbInPool = buildToString.intern(); // now in string pool
		System.out.println(sbInPool == str6inPool);
	}

}
