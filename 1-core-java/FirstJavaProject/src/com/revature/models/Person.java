package com.revature.models;

public class Person {
	private String name;
	private int age;
	private double height;
	private double weight;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public Person () {
		
	}
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	public void introduce() { //void just performs an action
		System.out.println("Hello my name is " + name);
	}
	
	//getters and setters//
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
	// overridingg the toString() method from the Iobject class
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
}
