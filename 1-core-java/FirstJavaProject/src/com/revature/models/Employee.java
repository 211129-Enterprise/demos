package com.revature.models;
/*
 * Inheritance in Java is the concept that allows classes to acquire properties
 * from other classes, like a son inherits properties father;
 * 
 * Abstraction - The process of hiding data that's not necessary to view.
 */

public class Employee extends Person {
	
	String dept;

	public Employee(String name, int age, double height, double weight) {
		super(name, age, height, weight);
		// TODO Auto-generated constructor stub
	}
	
	// DRY don't repeat yourself
	// name
	// age
	// height
	// weight
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
