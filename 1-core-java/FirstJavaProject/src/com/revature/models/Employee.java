package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/*
 * Inheritance in Java is the concept that allows classes to acquire properties
 * from other classes, like a son inherits properties father;
 * 
 * Abstraction - The process of hiding data that's not necessary to view.
 * 
 * We will make Employee Class a Java Bean
 * it is serializable
 * it has overridden hashCode and Equals
 * 
 * 
 * Serialization is the process of persisting an object from memory to a sequence of bits, like saving to a disc
 */

public class Employee extends Person implements Serializable {
	
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
