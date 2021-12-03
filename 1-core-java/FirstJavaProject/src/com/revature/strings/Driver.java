package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.) String Object created with the new keyword -> goes to the general heap.
		// 2.) String literal created with " " like String word = "something" goes to the string pool in the heap
		// 3.) 
		
		String stringObject = new String("straight to the general we go");
		System.out.println(stringObject);
		
		String str1 = "Hello"; // string literal -> string pool
		
		String str2 = "Hello"; // here, no new string object is created, the JVM checks if a string object matching this exact pattern exists in the string pool
		
		System.out.println("Does str1 have the same value as str2?" + str1.equals(str2)); //true
		
		System.out.println("Is str1 the same object as str2?" + (str1 == str2)); //true (address)
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		String str3 = new String("Hello");
		
		System.out.println(str3 == str2); // false, because one is an object and the other is in string pool.
		
		
	}

}
