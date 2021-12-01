package com.revature.abstraction;

public class Cat extends Animal {
	
	// the animal properties like legs and color are abstracted away from us
	
	//  because makeSound is abstract, we are forced to provide an implementation
	
	@Override
	public void makeSound() {
		System.out.println("ribbit ribbit");
	}

}
