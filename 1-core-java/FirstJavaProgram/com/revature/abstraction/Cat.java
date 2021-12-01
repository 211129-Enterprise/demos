package com.revature.abstraction;

public class Cat extends Animal{
	
	private boolean hasFur;

	//Because it extends animal, the unimplemented method must be implemented
	//The animal properties like legs and color are abstracted away from us
	//Also, makeSound is abstract so we are forced to provide an implementation
	@Override
	public void makeSound() {
		System.out.println("MEOW!!!");
		
	}

/* CONSTRUCTOR */
	public Cat(boolean hasFur) {
		super();
		this.hasFur = hasFur;
	}

/* GETTER & SETTER */
	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

/* TO STRING OVERRIDE */
	@Override
	public String toString() {
		return "Cat [hasFur=" + hasFur + "]";
	}
	
	
	
	
		

}
