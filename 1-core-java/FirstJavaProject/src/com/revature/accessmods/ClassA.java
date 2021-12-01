package com.revature.accessmods;

public class ClassA {
	
	/**
	 * 4 pillars of OOP
	 * 
	 * - A 
	 * - P
	 * - I
	 * - E
	 * 
	 * Abstraction, Polymorphism, Inheritence, Encapsulation
	 * 
	 * Encapsulation.. is a method of data and method can be wrapped in single unit
	 * we can restrict access to this data by using access modifiers
	 */
	
	// lets create some instance variables
	
	public int publicField = 1;
	private int privateField =2 ;
	int defaultField = 3; 
	protected int protectedField = 4;
	
	/**
	 * public - visible through entire project
	 * private - visible only inside class
	 * default - visible within  same package (almost public)
	 * protected - (almost like default) but  visible to child packages even if those classs are in other packages
	 */

	public static void main(String[] args) {
		// instatiate classA!
		
		ClassA classA = new ClassA ();
		
		// no problem accesing all of the fields
		System.out.println(classA.publicField);
		System.out.println(classA.privateField );
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
		
	}
	
	
	
	
}
