package com.revature.abstraction;

/**
 * Java does not support multiple inheritance, can only extend 1 class, but can
 * implement many interfaces
 */
public class Frog extends Animal implements Amphibious, Ectothermic {

	@Override
	public void makeSound() {

		System.out.println("Ribbit Ribbit");
	}

	@Override
	public void makeSound(int n) {
		for (int i = 0; i < n; i++)
			System.out.println("Ribbit");
	}

	// the following method can only be used if the object is created as an object
	// of this type, not if the liskov principle is used to create it
	// --Frog a = new Frog();-- Usable
	// --Animal a = new Frog();-- Not Usable
	public void makeMoreSound(int n) {
		for (int i = 0; i < n; i++)
			System.out.println("Ribbit");
	}

	@Override
	public String toString() {
		return "Frog []";
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub

	}

}
