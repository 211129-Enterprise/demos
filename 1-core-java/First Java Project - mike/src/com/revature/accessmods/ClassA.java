package com.revature.accessmods;

public class ClassA {
	/**
	 * 4 Pillars of OOP
	 * 
	 * 1. Abstraction
	 * 2. Polymorphism
	 * 3. Inheritance
	 * 4. Encapsulation
	 * 
	 */
	
	public int publicField = 1;
	private int privateField = 2;
	int defaultField = 3;
	protected int protectedField = 4;
	
	/*
	 * public = visible throughout the entire project
	 * 
	 * private = visible within the class ONLY
	 * 
	 * default = visible within the same package
	 * 
	 * protected = visible (like default) except also visible to child classes even if they are in other packages.
	 * 
	 */
	public static void main(String[] args) {
		// instantiate ClassA
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
		System.out.println(classA.privateField);
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
		
	}
}
