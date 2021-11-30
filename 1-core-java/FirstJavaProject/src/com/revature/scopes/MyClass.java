package com.revature.scopes;

/**
 * There are 4 scopes in Java
 *
 * 1. Class Scope (Static/Global Scope)
 * 2. Instance Scope (the variables that belong to specific objects)
 * 3. Method Scope (variables are confined to a respective method)
 * 4. Block Scope (think about the i variable that we use in a for loop, but can't access outside of the for loop)
 * 
 * The term "field" refers to a static or instance scoped variable
 * The "Local variable" refers to a method or a block scope
 */
public class MyClass {
	
	// class scope
	public static int myStaticvariable = 15;
	
	// instance scope
	public int myInstanceVar = 2;
	
	public void myMethod() {
		
		// does something
		
	}
	
}
