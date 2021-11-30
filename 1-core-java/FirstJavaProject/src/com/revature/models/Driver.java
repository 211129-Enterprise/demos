package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		// 2 people initialized with name only
		Person p1 = new Person("Ted");
		Person p2= new Person("Frank");
		
		System.out.println("p1's name is " + p1.getName());
		
		// an empty person
		Person p3 = new Person();
		
		Person p4 = new Person("Andrew", 25, 5.6, 180);
		Person p5 = new Person("Andrew", 25, 5.6, 180);
		
		// will .equals ring true for the above objects?
		// what about ==? /NO!
		
		p4.introduction();
		System.out.println(p4);
		
		System.out.println("_____________________________");
		
		System.out.println("does .equals() return true for p4 and p5? " + p4.equals(p5)); // must override the .equals method to make it true?
		
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
	}
	
}
