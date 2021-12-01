package com.revature.abstraction;

public class Frog extends Animal implements Amphibious , Ectothermic {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		
		System.out.println("I make sounds A");
		
	}
	

	public void  exist(int x) {
		System.out.println("hey hey");
	}


	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void CoolDown() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}
	
}
