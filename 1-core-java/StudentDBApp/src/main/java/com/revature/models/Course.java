package com.revature.models;

import java.util.Objects;

public class Course {

	public static final double COST_OF_COURSE = 600.00;
	private String name;

	
	
	// Constructor (w/ parameter)
	public Course(String name) {
		super();
		this.name = name;
	}


	
	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	// Override toString Method
	@Override
	public String toString() {
		return "course [name=" + name + "]";
	}
	
	
	
	// Override hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	// These ensure that if a course object has the same
	// string name property, it is considered the same in
	// value to another
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name);
	}
	
}
