package com.revature.accessmods;

public class ClassA {
	
	/**
	 * 4 Pillars of OOP
	 * 
	 *  - Abstraction
	 *  - Polymorphism
	 *  - Inheritance
	 *  - Encapsulation
	 *
	 *	Encapsulation is a mechanism in which data and methods can be wrapped
	 *	together in a single unit. We can restrict access to this data by using
	 *	access modifiers.
	 */

	// Let's create some instance variables
	public int publicField = 1;
	private int privateField = 2;
	int defaultField = 3; // this is default
	protected int protectedField = 4;
	
	/*
	 * public = visible throughout the entire project
	 * 
	 * private = visible within the class ONLY
	 * 
	 * default = visible within the same package
	 * 
	 * protected = visible (like default) except also visible to child classes
	 * 			   even if those chld classes are in other packages
	 */
	
	public static void main(String[] args) {
		
		// instantiate classA
		ClassA classA = new ClassA();
		
		// no problem accessing all of the fields
		System.out.println(classA.publicField);
		System.out.println(classA.privateField);
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
	}

	
	
}
//  you can build another class within the same file! (only one public class per file!)

class classD {
	
}