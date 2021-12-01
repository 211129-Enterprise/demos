package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/*
 * Inheritance 
 * - Allows classes to acquire properties from another class
 * 
 * Abstraction
 * - The process of hiding data that you don't need to see 
 * 
 * Bean is a standardized component
 * 
 * 
 * JAVA Bean, is a standard way to implemnt them
 * -all instances are private
 * -its serilizable - turn it into bits, deserilization called rehydrate
 * -it has overridden hasCode and Equals
 * 
 * What is the difference between a java bean and a POJO?

 */

public class Employee extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4472117562237788054L; // Don't need but useful, unique identifyer for the class
	// DRY Don't Repeat Yourself
		// Don't repeat name age height weight
		// these properties have been abstracted away
		
	private String dept; // to be a Bean all instance variables are private
	
	public Employee() { // to be a Bean must have an empty version of the object
		
	}
	
	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight); //adds this automatically, makes a call to the parent constructor
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dept);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept);
	}
	
	
}
