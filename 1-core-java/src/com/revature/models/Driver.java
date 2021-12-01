package com.revature.models;

// use this name for the place where the main method goes
public class Driver {
	public static void main(String[] args) {
		Person p1 = new Person(); // no args constructor, default constructor
		Person p2 = new Person();
		
		Person p4 = new Person("john", 43, 5.9, 175 );
		Person p5 = new Person("john", 43, 5.9, 175 );
		// are these .equals()??
		// what about == (testing objects in memory)
		p4.introduce();
		
		System.out.println(p4); // generates a hash code that contains its properties
		
		System.out.println("===============================");
		// to work we must override this method in Person
		// now it returns true
		System.out.println("Does .equals() work? " + p4.equals(p5));
		System.out.println(p5.hashCode());
		System.out.println(p4.hashCode());
		
		Employee e1 = new Employee("Fred",45, 6.3, 270, "marketing");
		
		e1.setName("bob");
		System.out.println(e1.getName());
		
		// Liskov
		
		// 
		
		
	}
}


