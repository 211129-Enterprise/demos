package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		
		// Liskov substitution seems to only allow the object to use methods created in the specifically declared method (Animal in this case) and not from anything created in the
		// child classes. However fields created in the child classes seem to work
		Animal a1 = new Cat(true);
		a1 = new Frog();
		
		a1.makeSound();
		a1.makeSound(5); // Works if created in the abstract class
//		a1.makeMoreSound(5); // Does not work
		
		//even if we create the frog directly as an animal it has the same result
		Animal a2 = new Frog();
		
		a2.makeSound();
		a2.makeSound(5); // Works if created in the abstract class
//		a2.makeMoreSound(5);
		
		// If we create the frog as a frog it all works
		Frog a3 = new Frog();
		
		a3.makeSound();
		a3.makeSound(5);
		a3.makeMoreSound(5);
		
		// but we lose the liskov substitution possibility
//		a3 = new Cat(true);
		
		a3.makeSound();
		
	}

}