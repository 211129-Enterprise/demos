package com.revature.abstraction;

public class Cat extends Animal {

	private boolean hasFur;

	@Override
	public void makeSound() {
		System.out.println("Meow");
	}

	@Override // we have to override all methods coming from an abstract parent class...
	public void makeSound(int i) {
		// I don't want the cat to make a bunch of noise... mine are already too
		// annoying lol

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
