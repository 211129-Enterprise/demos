package com.revature.accessmods;

public class ClassA {

	
	/*
	 * 4 Pillars of OOP
	 * 
	 * Abstraction
	 * Polymorphism
	 * Inheritance
	 * Encapsulation
	 * 
	 * 
	 * Encapsulation is a mechanism in which data methods can be wrapped together in a single unit. we c
	 * we can restrict access to this data by using access modifiers.
	 * 
	 * instance variables
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
	   * protected = visible (like default) except also visible to child 
	   * classes even if those child classes are in other packages.
	   */
	  
	  public static void main(String[] args) {
		  
		  ClassA classA = new ClassA();
		  
		  System.out.println(classA.publicField);
		  System.out.println(classA.privateField);
		  System.out.println(classA.defaultField);
		  System.out.println(classA.protectedField);
	  }
	   
	 
	 
}
