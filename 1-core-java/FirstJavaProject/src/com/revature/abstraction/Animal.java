package com.revature.abstraction;

// Abstract classes cannot be instantiated
public abstract class Animal{

	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("The animal constructor has been called");
	}
	
	// Abstract methods are methods that have no body and are intended to be inherited and overridden.
	public abstract void makeSound();
	//if we add the version that takes an int here it works in frog, but now we have to implement it in cat too...
	public abstract void makeSound(int i);
	
	// if we make this final then we can't overwrite it
	public void exist() {
		System.out.println("THE ANIMAL EXISTS");
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	
	
}
