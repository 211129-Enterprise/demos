package com.revature.models;

import java.util.Objects;

public class Person {
	
	// properties(state)
	
	
	// Instance Variables - properties specific to each Person object that's instantiated
	
	private String name;
	private int age;
	private double height;
	private double weight;
	
	// constructors
	public Person() {
		//this is a no-args constructor 
	}
	
	public Person(String name) {
		super(); // I'm calling the Object class (or direct parent class)
		this.name = name; // this points to the specific object I'm instantiating
	} 
	
	
	
	// FULLY initalize person
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	
	// method (behaviors)
	public void introduce() {
		System.out.println("hello my name is " + name);//by dafult we know that name refers to the instance variable of this
		// object thats calling it by default, we know that name refers to the instance variable of this object thats calling it
	}
	
	
	//we must generate getters and setters so we can change the private
	//properties of the objects that are created from this class
	
	
	// right click -> source -> generate getters & setters
	
	
	
	public static void main(String[] args) {
	
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
