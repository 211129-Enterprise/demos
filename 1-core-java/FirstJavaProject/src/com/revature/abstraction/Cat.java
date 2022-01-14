package com.revature.abstraction;

public class Cat extends Animal {
	
	private boolean hasFur;

	@Override
	public void makeSound() {
		System.out.println("Meow");
		
	}

	public Cat(boolean hasFur) {
		super();
		this.hasFur = hasFur;
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
