package com.revature.abstraction;

/**
 * Java does not support multiple inheritance, can only extend 1 class, but can implement many interfaces
 */
public class Frog extends Animal implements Amphibious, Ectothermic{

	@Override
	public void makeSound() {

		System.out.println("Ribbit Ribbit");
	}
	
	public void makeSound(int n) {
		for (int i = 0; i<n;i++)
			System.out.println("Ribbit");
	}
	
	public void makeMoreSound(int n) {
		for (int i = 0; i<n;i++)
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
