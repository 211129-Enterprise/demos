package com.revature.lambdas;

// creating my own functional interface
public interface UpperConcat {
	
	// any class that implements this, MUST provide an implementation of this one method
		public String upperAndConcat(String s1, String s2);
}