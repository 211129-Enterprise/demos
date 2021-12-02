package com.revature.accessmods;

public class ClassB {
	
	public static void main(String[] args) {
		  ClassA classA = new ClassA();
		  System.out.println(classA.publicField);
		  // private field is not supposed to work
//		  System.out.println(classA.privateField);
		  System.out.println(classA.defaultField);
		  System.out.println(classA.protectedField);
	}

}
