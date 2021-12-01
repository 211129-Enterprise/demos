package com.revature.otherpackage;

import com.revature.accessmodifiers.ClassA;

public class ClassC extends ClassA {
	
	public static void main(String[] args) {
		//instaniate classA
		ClassA classA = new ClassA();
		ClassC classC = new ClassC(); //need to instantiate class C to inherit the protected field.
		
		System.out.println(classA.publicField);
		System.out.println(classA.privateField);
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
		
		System.out.println(classC.privateField);
		System.out.println(classC.defaultField);
		System.out.println(classC.protectedField); //notice you can pull the protected field.
		
		System.out.println(classC.protectedField);
		
	}
	
}
