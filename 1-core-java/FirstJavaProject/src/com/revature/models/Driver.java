package com.revature.models;

public class Driver {

	public static void main(String[] args) {
		
		Person p1 = new Person(); // if WE don't provide a constructor, the JVM will automatically create a default-constructor (no-args constructor)
		Person p2 = new Person();
		
		p1.setName("Bob");
		
		System.out.println("p1's name is " + p1.getName()); // this will return null because we haven't provided P1 with a name
		 

		Person p3 = new Person("Jimmy");
		
		Person p4 = new Person("Sally", 40, 5.6, 150);
		Person p5 = new Person("Sally", 40, 5.6, 150); 
		// will .equals() ring true for the above objects? // tests for value
		// what about == (testing address in memory)? / NO!
	
		
		p4.introduce();
		
		System.out.println(p4);
		
		System.out.println("=====================================");
		
		System.out.println("Does .equals() return true for both p4 and p5? " + p4.equals(p5)); 
		// we must OVERRIDE the .equals method inherited from the Object class
		
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
		
	}

}
