package com.revature.models;

import java.util.Objects;

// Remember that our custom class inherits from the java.lang.Object class
public class Person { // POJO = Plain Old Java Object

	// properties (states)
	
	// Instance variables - properties specific to each Person object that's instantiated
	private String name;
	private int age;
	private double height;
	private double weight;
	
	// constructors
	public Person(String name) {
		super(); // I'm calling the Object class (or direct parent class)
		this.name = name; // this points to the specific object that I'm instantiating's NAME property
		
	}
	
	// a FULLY initialized person
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	// method (behaviors)
	
	public void introduce() { // void is a non-access modifier - specifies the return type which is nothing - it just does something
		System.out.println("Hello my name is " + name); // by default, we know that name refers to the instance variable of this object
	}
	
	// we must generate getters & setters so that we can change the private 
	//	properties of objects that are created from this class
	
	// right click => source => generate getters and setters
	
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
	
	// we can override a method that we inherit from the Object class
	@Override // overriding the toString() method from the Object class to properly reflect the specific instance variable 
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(age, height, name, weight);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		return age == other.age && Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
//				&& Objects.equals(name, other.name)
//				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
//	}
//	
	
	
}
