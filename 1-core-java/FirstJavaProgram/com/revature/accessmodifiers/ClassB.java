package com.revature.accessmodifiers;

public class ClassB {
	public static void main(String[] args) {
		//instaniate classA
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
	//	System.out.println(classA.privateField); //cannot get
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
		
	}
}
