package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		
		Person p1 = new Person(); // If we don't provide a constructor , the JVM will automaticlly create a default-constructor 
		Person p2 = new Person();
		
		p1.setName("Bob");
		System.out.println("p1's name is " + p1.getName());
		
		Person p3 = new Person ("Jimmy");
		
		Person p4 = new Person("Sally" , 40, 5.6, 150);
		Person p5 = new Person ("Sally", 40, 5.6, 150);
		//will .equals ring true for the above objects? // tests for value
		//what about == (testing address in memory?) NO!
		
		p4.introduce();	
		
		System.out.println(p4);
		System.out.println(p4.equals(p5));
	}
}
