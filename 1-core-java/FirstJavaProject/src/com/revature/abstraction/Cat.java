package com.revature.abstraction;

public class Cat extends Animal{

	private boolean hasFur;
	
	public Cat(boolean hasFur) {
		super();
		this.hasFur = hasFur;
	}

	@Override
	public void makeSound() {
		System.out.println("meow");
	}

	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public String toString() {
		return "Cat [hasFur=" + hasFur + "]";
	}

}
