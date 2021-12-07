package com.revature.abstraction;

/**
 * Java does not support multiple inheritance so it can
 * extend ONE class, (only one) but it can implement MANY interfaces)
 * 
 * Abstraction is the process of hiding certain details and showing only essential informationt ot he user.
 * 
 * This is achieved with interfaces and abstract classes in Java. You can't
 * instantiate either an abstract class OR an interface.
 * 
 * When we talk about abstract classes we are defining characteristics of an
 * object type; specifying what an object is.
 * 
 * When we talk about an interface and define capabilities that we promise to
 * provide, we are talking about establishing a contract about what the object
 * can do.
 * 
 * https://stackoverflow.com/questions/479142/when-to-use-an-interface-instead-of-an-abstract-class-and-vice-versa
 */


public class Frog extends Animal implements Amphibious, Ectothermic {
	
	// the animal properties like legs and color are abstracted away from us
	
	// because makeSound is abstract, we are forced to provide an implementation
	
	@Override
	public void makeSound() {
		System.out.println("ribbit ribbit");
		
	}
	
	// overloading
	public void makeSound(int n) {
		for (int i=0; i<n; i++) {
			System.out.println("ribbit");
		}
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}
	
	// Frog has access to animal getters and setters
}
