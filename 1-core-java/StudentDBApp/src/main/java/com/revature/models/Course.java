package com.revature.models;

import java.util.Objects;

public class Course {
	
	private String name;
	public static final double COST_OF_Course = 600.00;
	
	//constructor----------------------------------------------------------
	public Course(String name) {
		super();
		this.name=name;
		
	}

	//getters/setters-------------------------------------------------------
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//toString method-------------------------------------------------------
	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	public static double getCostOfCourse() {
		return COST_OF_Course;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	//Hashcode and equals -----------------------------------------------------
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