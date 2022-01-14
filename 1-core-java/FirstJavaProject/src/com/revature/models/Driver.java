package com.revature.models;

public class Driver {
<<<<<<< HEAD
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println("The name of the person is "+p1);//This prints a null because we have not set a name.
		
		Person p2 = new Person("Jimmy");
		p2.introduce();
		
		Person p3 = new Person("Sally", 25, 163, 42.5);
		Person p4 = new Person("Sally", 25, 163, 42.5);
		
		//Will .equals return true for the two above us? .equals tests for values. For it to be equal we must override what .equals does.
		System.out.println(p3.equals(p4));
		
		//Will it return for == which tests for the position in memory?
		System.out.println(p3 == p4);
		
		System.out.println(p3);
		
		//Liskov Substitution Principal, sub classes should be interchangable with one another
		Employee e1 = new Employee("Larry", 38, 203, 89, "Finance");
		System.out.println(e1.getAge());//Despite not being defined within employee the getName getter is still available. Thanks to inheritance we don't need to redo it.
		//Abstraction means it doesn't need to be shown either. 
		//e1 = new Artist();
		
	}
=======

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
		
		System.out.println("=====================================");
		
		// Liskov Substitution Priciple - google
		Person e1 = new Employee("Larry", 45, 6.2, 270, "Finance");
		// e1 = new Artist(); // this is the Liskov Substitution Priciple at work 
		
		String name = e1.getName();
		System.out.println(name);
		
		((Employee) e1).getDept();
		
//		e1.name = "Garry";
		e1.setName("Garry");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
}
