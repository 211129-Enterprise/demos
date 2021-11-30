package com.revature.scopes;

/**
 * 
 * There are 4 scopes in java
 * 
 * 1. Class (Static/Global)
 * 2. Instance (variables that belong to specific objects)
 * 3. Method (variables within methods)
 * 4. Block (Think about the variable used in a for loop, but can't be accessed outside that loop)
 * 
 * The term "field" refers to a static or instance scoped variable.
 * 
 * Local Variable - Refers to a method or block scope variable
 */

public class MyClass {

	//class scope
	public static int myStaticVariable = 15;

	//instance scope
	public int myInstanceVar = 2;
	
	public void myMethod() {
		//does something
	}
}
