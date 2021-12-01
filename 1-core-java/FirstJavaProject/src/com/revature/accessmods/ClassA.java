package com.revature.accessmods;

public class ClassA {

	/**
	 * 
	 * 4 Pillars of OOP
	 * 
	 * A -- Abstraction
	 * P -- Polymorphism
	 * I -- Inheritance
	 * E -- Encapsulation - Mechanism in which data and methods can be wrapped into a single unit. We can restrict access using access modifiers.
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	// Instance Variables
	
	public int publicField = 1;
	private int privateField = 2;
	int defaultField = 3; 				// This is default by default, does not need default keyword, just to have no other keyword
	protected int protectedField = 4;
	
	/**
	 * Public = visible throughout project
	 * 
	 * private = visible within class only
	 * 
	 * default = visible within package
	 * 
	 * protected = visible (like default) except also visible to child classes even when in other packages
	 */
	
	
	
	
	public static void main(String[] args) {
		
		// Instantiate this class
		ClassA classA = new ClassA();
		
		// can access all fields here
		
		System.out.println(classA.publicField);
		System.out.println(classA.privateField);
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
// can build other classes in same files, but only 1 can be a public class
class ClassD{
	
}
