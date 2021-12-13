package com.revature.lambdas;

// Creating my own functional interface
public interface UpperConcat {
		
		// Any class that implements this, MUST provide an implementation of this one method
		public String upperAndConcat(String s1, String s2);

}