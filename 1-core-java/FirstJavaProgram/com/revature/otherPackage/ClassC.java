package com.revature.otherPackage;

import com.revature.accessmods.ClassA;

public class ClassC extends ClassA{

	
	public static void main(String[] args) {
		
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
		System.out.println(classA.privateField); //Can't access because we're not in ClassA file
		System.out.println(classA.defaultField); //Can't access due to Different package
		System.out.println(classA.protectedField); //We can't access directly. Class C must extend class A
		
		//We need to instantiate Class C because it inherits from Class A
		//
		ClassC classC = new ClassC();
		System.out.println(classC.defaultField); //Can't access this because even though ClassC is a subclass, 
												 //it's a different package
		System.out.println(classC.protectedField);//This field is inherited from Class A because that's the parent class
	}
}
