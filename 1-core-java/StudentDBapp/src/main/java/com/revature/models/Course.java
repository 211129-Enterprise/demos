package com.revature.models;

import java.util.Objects;

public class Course {
	private String name ;
	final static public double COST_OF_COURSE = 600.00 ;
	
	
	
	public Course(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	

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
