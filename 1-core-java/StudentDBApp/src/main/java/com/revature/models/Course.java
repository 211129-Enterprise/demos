package com.revature.models;

import java.util.Objects;

public class Course {
	
<<<<<<< HEAD
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
=======
	public static final double COST_OF_COURSE = 600.00;
	
	private String name;

	// constructor (with parameterized)
	public Course(String name) {
		super();
		this.name = name;
	}

	
	// getters & setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	// toString method
>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
<<<<<<< HEAD
	public static double getCostOfCourse() {
		return COST_OF_Course;
	}

=======


	// This ensures that if Course obj has the same String name property
	// it is considered the same in value to another
>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
<<<<<<< HEAD
	//Hashcode and equals -----------------------------------------------------
=======


>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
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
<<<<<<< HEAD
	
}
=======

}
>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
