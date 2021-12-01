package com.revature.models;

import java.util.Objects;

// custom class inherits from the java.lang.Object class
public class Person { // POJO = Plain Old Java Object
	// properties (states)
	
	// Instance variable - properties specific to each person 
	private String name;
	private int age;
	private double height;
	private double weight;
	
	// constructors
	public Person() {
		//no args constructor
	}
	
	
	// fully initialized person
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	// methods (behaviors)
	public void introduce() { // void is called a non-access-modifier, doesn't change how we access the method
		System.out.println("hello my name is " + name); // by defualt we know tha tname refers to the instance variable 
	}
	
	
	
	// generate getters and setters to change the instance variables:
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

	// lets overried a method that we inherit
	// properly reflects the specific instance variable 
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(age, height, name, weight);
	}

	// we have told our program that so long as our objects have the same value we will consider them equal
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
