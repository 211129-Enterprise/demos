package com.revature.models;

public class Driver {
	public static void main(String[] args) {
		
		Person p1 = new Person(); 
		Person p2 = new Person();
		
		p1.setName("Bob");
		System.out.println("his name is "+p1.getName());
		
		Person p3 = new Person("Jimmy");
		Person p4 = new Person("Sally", 40, 5.6, 150);
		
		p4.introduce();
		System.out.println(p4);
		
	}
}
