package com.revature.abstraction;

/*
 * Java does NOT support multiple inheritance
 * It can extend ONLY ONE class but it can 
 * implement MANY interfaces
 * 
 * Abstraction is the process of hiding certain details and showing only
 * essential information to the user.
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
 */
public class Frog extends Animal implements Amphibious, Ectothermic{

	//Because it extends animal, the unimplemented method must be implemented
	//The animal properties like legs and color are abstracted away from us
	//Also, makeSound is abstract so we are forced to provide an implementation
	@Override
	public void makeSound() {
		System.out.println("Ribbit! Ribbit!");
		
	}
	
	//Overloading
	public void makeSound(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println("Ribbit!");
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
	
	//Frog has access to Animal getter and setters
}
