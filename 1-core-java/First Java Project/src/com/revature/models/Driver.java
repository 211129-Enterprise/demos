package com.revature.models;

public class Driver {

	public static void main(String[] args) {

		Person p1 = new Person();
		Person p2 = new Person();
		
		p1.setName("Bob");
		
		System.out.println("p1's name is " + p1.getName());

		Person p3 = new Person("Jimmy");
		Person p4 = new Person("Carl", 20, 72.5, 180.89);
		Person p5 = new Person("Carl", 20, 72.5, 180.89);
		
		System.out.println(p4.equals(p5));
		System.out.println(p4 == p5);
		
		p4.introduce();
		
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
		
		// Liskov Substitution Principle
		Person e1 = new Employee("Larry", 45, 6.2, 270, "Finance");
		
		String name = e1.getName();
		System.out.println(name);
		
	}

}
