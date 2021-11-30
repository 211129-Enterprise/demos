package com.revature.models;

import java.util.Objects;

public class Person {
	//POJO-Plain Old Java Object
	
	//properties (states)
	//Instance variable - variables specific to every object created by a class
	private String name;
	private int age;//Private is an access modifier 
	private double height;
	private double weight;
	
	//Constructors
	public Person () {
		//This is a no args constructor
	}
	
	//Takes only the name as an argument
	public Person(String name) {
		super();//Calls the object class (or direct parent). Usually you want to use this as the first line of a constructor.
		this.name = name;
	}
	
	//Takes all variables as arguments
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	//Methods (actions)
	public void introduce() {//Use the void return type for methods that perform action and don't pass information back.
		System.out.println("Hi my name is "+name);
	}
	
	//We must use getters and setters to change the private properties of a class. 
	//right click -> source ->generate getters and setters
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
	
	//Overrides the standard printing format from the object class with a more specific form that includes the instance variables of a person object.
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
