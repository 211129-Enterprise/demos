package com.revature.abstraction;

public class Frog extends Animal implements Amphibious, Ectothermic{

	private int bodyTemp = 20;
	@Override
	public void makeSound() {
		System.out.println("ribbit");
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		bodyTemp += 10;
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		bodyTemp -= 10;
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("Swimming");
	}

	@Override
	public String toString() {
		return "Frog [bodyTemp=" + bodyTemp + "]";
	}
	
}
