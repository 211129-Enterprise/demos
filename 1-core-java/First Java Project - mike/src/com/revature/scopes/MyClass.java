package com.revature.scopes;

/**
 * 
 * @author michael
 * 
 * 1. Class scope (Static/Global scope)
 * 2. Instance scope (the variables that belong to specific objects)
 * 3. Method scope (variables confined to a respective method)
 * 4. Block scope (think about the i variable that we use in a for loop, but can't access outside of the for loop)
 * 
 * The term "field" refers to a static or instance scoped variable
 * The "local variable" refers to a method or a block scope
 *
 */

public class MyClass {
	
	// class scope
	public static int myStaticVariable = 15;
	
	// instance scope
	public int myInstanceVar = 2;
	
	public void myMethod() {
		
	}

}
