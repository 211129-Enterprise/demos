package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		Animal a1 = new Cat(true);
		System.out.println(a1);
		a1 = new Frog();
		((Frog) a1).coolDown();
		System.out.println(a1);
	}

}
