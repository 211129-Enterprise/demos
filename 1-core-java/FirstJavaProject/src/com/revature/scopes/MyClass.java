package com.revature.scopes;

public class MyClass {
	
	//Class scope
	public static int myStaticVariable = 15;
	
	//Instance scope
	public int myInstanceVariable = 13;
	
	public void myMethod() {
		//Method scope
		int myMethodVariable;
		
		if(true) {
			//Block scope
			int myBlockVariable;
		}
	}
}
