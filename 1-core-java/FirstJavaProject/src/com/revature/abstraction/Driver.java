package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		
		Animal a1 = new Cat(true); // makes a call to the super constructor
		
		// Animal is the refernce type...

		// we can re-assign this reference variable to an instance of a Frog
		
		a1 = new Frog();
		
		a1.makeSound();
	}
	
	public static void makeGeneralANimalSound(Animal someAnimal) {
		
		// this will output the overridden version of the child class' method
		someAnimal.makeSound();
		
	}

}
