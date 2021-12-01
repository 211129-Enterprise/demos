package com.revature.abstraction;

public abstract class Animal {
	private String colorString;
	private int legs ;
	
	public Animal() {
		
	}

	public abstract void makeSound();
	
	public void exist() {
		System.out.println("I Exist");
	}

	public String getColorString() {
		return colorString;
	}

	public void setColorString(String colorString) {
		this.colorString = colorString;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}
	
	
	
	
}
