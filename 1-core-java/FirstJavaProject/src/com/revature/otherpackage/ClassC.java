package com.revature.otherpackage;

import com.revature.accessmods.ClassA;

public class ClassC extends ClassA {

	public static void main(String[] args) {
		
		// Instantiate this class
		ClassA classA = new ClassA();
		
		// can access all fields here
				
		System.out.println(classA.publicField);
//		System.out.println(classA.privateField);	// cannot access private field due to not being in class
//		System.out.println(classA.defaultField);	// cannot access default due to not being in package
//		System.out.println(classA.protectedField);	// cannot access default due to not being in seperate package without being a child
		
		ClassC classC = new ClassC();
		
		
//		System.out.println(classC.defaultField);	// can't access still as it is in a different package
		System.out.println(classC.protectedField); 	// to access protected field must extend the other class and import and instantiate current class
													// Then must access through object of this class.
		
		
	}
}
