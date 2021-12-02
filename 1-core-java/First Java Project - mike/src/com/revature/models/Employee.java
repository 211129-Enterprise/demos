package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

// we will make employee class a java bean
//  - all instance variables are private
//  - it is serializable
//  - it has overridden hashCode and Equals
//  - getters and setters included

// serialization is the process of persisting an object from memory to a sequence of bits, like saving it to your disk.

public class Employee extends Person implements Serializable{
	
	
	
	// instance variables should be private for best practice
	private String dept;

	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight);
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
