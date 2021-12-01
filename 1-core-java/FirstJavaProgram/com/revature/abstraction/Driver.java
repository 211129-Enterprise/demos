package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		//Animal a1 = new Animal(); <--Can't do that
		Animal a1 = new Cat(true); //Makes a call to super constructor
		//Animal is the reference type
		//We can re-assign this reference variable to an instance of a Frog
		
		a1 = new Frog(); // Means that now two objects have been created because instance of Cat class
						 // was garbage collected
	}
}
