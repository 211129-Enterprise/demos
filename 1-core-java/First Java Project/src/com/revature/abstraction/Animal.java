package com.revature.abstraction;

import java.util.Objects;

public abstract class Animal {

	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("The animal constructor has been called!");
	}
	
	// abstract methods are methods that have no body and are intended to be inherited, overridden and implemented in child class
	public abstract void makeSound();
	
	public void exist() {
		System.out.println("I EXIST!");
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

	@Override
	public int hashCode() {
		return Objects.hash(color, legs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(color, other.color) && legs == other.legs;
	}
	
	
	
}
