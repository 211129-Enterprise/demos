package com.revature.models;

public class Driver {

	public static void main(String[] args) {

		// no-args
		Person p1 = new Person();
		Person p2 = new Person();

		// we can also use getter/setters to add value to fields/properties
		p1.setName("Bob");

		System.out.println("p1's name is " + p1.getName());

		Person p3 = new Person("Jimmy");

		System.out.println(p3.getName());

		// public Person(String name, int age, double height, double weight)
		Person p4 = new Person("Sally", 35, 5.8, 220);
		Person p5 = new Person("Sally", 35, 5.8, 220);
		// will .equals() be true for p4.equals(p5)
		
		
		
		p1.introduce();
		p2.introduce();
		p3.introduce();
		p4.introduce();
	
		
		System.out.println(p4);
		
		System.out.println(p4 == p5);
		System.out.println(p4.equals(p5));
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
		
		
		
		
	}

}
