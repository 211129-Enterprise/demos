package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		
		Animal a1 = new Cat(true);
		a1 = new Frog();
		
		a1.makeSound();
		a1.makeSound(5);
		a1.makeMoreSound(5);
		
		Animal a2 = new Frog();
		
		a2.makeSound();
		a2.makeSound(5);
		a2.makeMoreSound(5);
		
		Frog a3 = new Frog();
		
		a3.makeSound();
		a3.makeSound(5);
		a3.makeMoreSound(5);
		
		a3 = new Cat(true);
		
		a3.makeSound();
		
	}

}