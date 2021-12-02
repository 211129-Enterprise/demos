package com.revature.otherpackage;

import com.revature.accessmods.ClassA;

public class ClassC extends ClassA {

	
	public static void main(String[] args) {
		
		// instantiate a ClassA
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
//		System.out.println(classA.privateField);
//		System.out.println(classA.defaultField);
//		System.out.println(classA.protectedField);
		
		ClassC classC = new ClassC();
		
		System.out.println(classC.publicField);
		System.out.println(classC.protectedField);
		
	}
	
	
}
