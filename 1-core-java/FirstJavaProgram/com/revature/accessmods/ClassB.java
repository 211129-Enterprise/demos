package com.revature.accessmods;

public class ClassB {

	//Instantiate ClassA
	ClassA classA = new ClassA();
	
	
	System.out.println(classA.publicField);
	System.out.println(classA.privateField); //We can't access the private field because we're not in ClassA file
	System.out.println(classA.defaultField);
	System.out.println(classA.protectedField);
	
}
