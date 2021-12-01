package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
	
		Animal a1 = new Cat(true);
		
		// Animal is the reference type...
		// we can re-assign this reference variable to an instance of a Frog
		
		a1 = new Frog();
		
	}
	
}
