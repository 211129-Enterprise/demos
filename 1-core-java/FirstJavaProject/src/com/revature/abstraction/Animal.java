package com.revature.abstraction;

// An abstract class CANNOT be instnatiated
public abstract class Animal {

	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("The animal constructor has been called!");
	}
	
	// abstract methods are methods that have no body and are intended to be inherited and (overidden) implemented
	public abstract void makeSound();
	
	// if we added final here we couldn't override
	public void exist() {
		System.out.println("I EXIST!");
	}

	
	// getters & setters
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
