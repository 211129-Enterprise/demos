package com.revature.abstraction;

public abstract class Animal {
	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("Animal Constructor");
	}
	
	public abstract void makeSound();

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
