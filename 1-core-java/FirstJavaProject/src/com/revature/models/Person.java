package com.revature.models;

public class Person {
    // properties
	
	// Instance variables - properties specific to each person object
	private String name;
	private int age;
	private double height;
	private double weight;
	
	// constructors
	public Person(String name, int age, double height, double weight) {
		super(); // Im calling the object class or direct parent class if inheritance is involved
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// method(behaviors)
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
}
