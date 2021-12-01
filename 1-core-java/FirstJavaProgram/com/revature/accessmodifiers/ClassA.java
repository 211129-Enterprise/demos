package com.revature.accessmodifiers;


public class ClassA {
	public int publicField = 1;  //visible throughout the entire project//
	private int privateField = 2; // visible within class only//
	int defaultField = 3;         // visible within same package//
	protected int protectedField = 4; //visible (like default) except visible to child classes //
										//even if those child classes are other packages.//
	
	public static void main(String[] args) {
		//instaniate classA
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
		System.out.println(classA.privateField);
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
		
	}
}