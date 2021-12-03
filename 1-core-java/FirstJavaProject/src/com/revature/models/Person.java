package com.revature.models;

import java.util.Objects;

// This is gonna be a custom class
// Our custom class inherits from the java.lang.Object class

public class Person {

	// A (custom) class has 2 things

	// properties (states) - instance variables , static variables
	// instance variables - properties specific to each Person object that's
	// instantiated
	//

	private String name;
	private int age;
	private double height;
	private double weight;

	// constructors

	public Person() {
		// this is no args constructor
	}

	public Person(String name) {
		super();
		this.name = name; // this points to 'THIS' specific object being instantiated
		// this. objects name property (property is simillar to variable in JS) is equal
		// to incoming variable 'name'

	}

	// Fully initialized Person
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	// getters and setters -> so that we can change private properties of the
	// objects that are created form this class

	


	public Person(String name) {
		super();
		this.name = name;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// method (behaviors)

	public void introduce( ) {
		System.out.println("Hello my name is " + name); // we didn't need to call this.name because we know 'name' refers to the instance variable that's calling it
	}

	
	// we can over ride a method we inherit
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, height, name, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
