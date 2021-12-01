package com.revature.otherpackage;

import com.revature.accessmods.ClassA;

public class ClassC  extends ClassA {
	public static void main(String[] args) {
		 ClassA classA = new ClassA();
		 
		 	System.out.println(classA.publicField); // only filed we are able to capture in public 
			System.out.println(classA.privateField );
			System.out.println(classA.defaultField);
			System.out.println(classA.protectedField); //we could access the protected field 
			
			
		ClassC classC = new ClassC();
		
		System.out.println(classC.publicField); // only filed we are able to capture in public 
		System.out.println(classC.privateField );
		System.out.println(classC.defaultField); // cant access this because even throuh class C is a subclass its a diff pacakge
		System.out.println(classC.protectedField); //this field is inherited from classA because classA is parent class
		
		
	}
}
