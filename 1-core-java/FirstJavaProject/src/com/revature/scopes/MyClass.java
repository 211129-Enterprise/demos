/**
 * 
 */
package com.revature.scopes;

/**
 * @author haugh
 *1.Class Scope-Variables confined to the class. (Static/Global)
 *2.Instance Scope-Variables confined to an instance of an object.
 *3.Method Scope-Variables confined to a specific method.
 *4.Block Scope-Confined to only its block of code.
 */
public class MyClass {
	public static int myStaticVariable = 15;
	
	public int myInstanceVar;
	
	public void myMethod() {
		//does something
	}
	
}
