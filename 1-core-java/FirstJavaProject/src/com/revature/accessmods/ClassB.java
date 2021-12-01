package com.revature.accessmods;

public class ClassB {
	 public static void main(String[] args) {
		// instatiate classA!
		 
		 ClassA classA = new ClassA();
		 
		 System.out.println(classA.publicField);
			System.out.println(classA.privateField ); // we can't access the private field because we are not in the C
			System.out.println(classA.defaultField);
			System.out.println(classA.protectedField);
	}
}
