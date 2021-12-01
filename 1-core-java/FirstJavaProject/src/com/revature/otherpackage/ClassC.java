package com.revature.otherpackage;

import com.revature.accessmods.ClassA;

public class ClassC extends ClassA {

	public static void main(String[] args) {
		
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
//		System.out.println(classA.privateField);
//		System.out.println(classA.defaultField);
//		System.out.println(classA.protectedField);
		
		ClassC classC = new ClassC();
		
//		System.out.println(classC.defaultField);// can't access this because even though ClassC is a subclass,
//												// it's a different package
		System.out.println(classC.protectedField); // this field is inherited from Class A because that's the parent class
		
		
	}
	
}
