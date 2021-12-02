package com.revature.models;

import java.util.Objects;

public class Course {

	public static final double COST_OF_COURSE = 600.00;
	private String name;
	
	
	//constructors (with parameterized)
	public Course(String name) {
		super();
		this.name = name;
	}


	//getters & setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}


	//override hashcode and equals  - this ensures that if a course object has the same name property
	//it is considered the same in value to another or its gonna have the same hashcode property
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}


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
