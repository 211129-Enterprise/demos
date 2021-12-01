package com.revature.accessmods;

public class ClassB {
	ClassA classA = new ClassA();
	
  System.out.println(classA.publicField);
  System.out.println(classA.privateField);
  System.out.println(classA.defaultField);
  System.out.println(classA.protectedField);
}
