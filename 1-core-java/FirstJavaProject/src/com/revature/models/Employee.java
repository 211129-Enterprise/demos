package com.revature.models;

import java.io.Serializable;

//Inheritance in Java
//Allows classes to acquire properties from other classes.
//Abstraction is the process of hiding unneeded information. Mainly done through interfaces.

//Serialization is the process of persisting an object from memory to a series of bits, like saving onto the disk.

public class Employee extends Person implements Serializable{
	
	//serial version uid is a unique identifier for each class
	
	

	public Employee(String name, int age, double height, double weight, String dept) {
		// TODO Auto-generated constructor stub
		this.dept = dept;
	}
	
	private static final long serialVersionUID = 123456789;
	
	//An employee is a person so we should apply the DRY principal.
	//Don't Repeat Yourself
	//name
	//age
	//height
	//weight
	private String dept;



	public String getDept() {
		return dept;
	}



	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
