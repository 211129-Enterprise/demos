package com.revature.otherpackage;

import com.revature.accessmods.ClassA;

public class ClassC extends ClassA {

	public static void main(String args[]) {
		
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
		
		ClassC classC = new ClassC();
		System.out.println(classC.publicField);
		System.out.println(classC.protectedField);
		
	}
	
}
