package com.revature.abstraction;

// An abstract class CANNOT be instantiated
public abstract class Animal { //CANNOT extend a final class, so wouldn't work for this abstract class
	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("The animal constructor has been called!");
	}
	
	//Can also use abstract class for abstract method
	//Abstract methods are methods that have no body and are intended to be inherited and overridden in their implementation
	public abstract void makeSound();
	
	public void exist() {
		System.out.println("I EXIST!");
	}
//	public final void exist() { //If made final, we can't override it elsewhere like in Frog
//		System.out.println("I EXIST!");
//	}

	
/* GETTERS & SETTERS */
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
