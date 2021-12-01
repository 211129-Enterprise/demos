package com.revature.accessmods;

public class ClassA {
	
	public int publicField = 1;
	private int privateField = 2;
	int defaultField = 3;
	protected int protectedField = 4;
	
	public static void main(String[] args) {
		ClassA classA = new ClassA();
		
		System.out.println(classA.publicField);
		System.out.println(classA.privateField);
		System.out.println(classA.defaultField);
		System.out.println(classA.protectedField);
		
	}
}

class ClassD {
	
}