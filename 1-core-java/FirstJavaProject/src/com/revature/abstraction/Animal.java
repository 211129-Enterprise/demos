package com.revature.abstraction;

public abstract class Animal {
	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("The animal constructor");
	}
	
	public abstract void makeSound();
	
	public void exist() {
		System.out.println("I exist.");
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
