package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		
		Animal a1 = new Cat(true); // makes a call to the super constructor
		
		// Animal is the refernce type...
		// we can re-assign this reference variable to an instance of a Frog
		
		a1 = new Frog();
		
		Frog f1 = new Frog();
		
		f1.makeSound(3); // this is the overloaded method
		
		a1.makeSound(); // this will call the concrete class' implementation OF the abstract parent class method

	}
	
	public static void makeGeneralANimalSound(Animal someAnimal) {
		
		// this will output the overridden version of the child class' method
		someAnimal.makeSound();
		
	}

}
