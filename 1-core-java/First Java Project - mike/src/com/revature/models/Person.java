package com.revature.models;

import java.util.Objects;

// Custom class inherits from the java.lang.Object class
public class Person { // POJO = Plain Old Java Object
	
	// properties
	
	// Instance variable - properties specific to each instantiation of Person
	private String name;
	private int age;
	private double height;
	private double weight;
	
	
	// methods
	public void introduce() {
		System.out.println("Hello my name is " + name);
	}
	
	// constructor
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public Person() {
		// no-args constructor
	}
	
	
	// getter and setter methods
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

	@Override // overriding the toString method from the Object class to properly reflect the properties
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
	
	// we can override a method we inherit from the Object class
	
	
}
