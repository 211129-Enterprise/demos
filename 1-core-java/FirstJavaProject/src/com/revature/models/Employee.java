package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * Inheritance in java is the concept that a class acquires properties from another class
 * 
 * Abstraction: The process of hiding data that's not necessary to view.
 * 
 * We will make Employee Class a Java Bean
 * 
 * JAVA BEAN RULES:
 * -- all instance variables are private
 * -- it is serializable
 * -- it has overridden hash code and equals
 * -- it has getters and setters
 * 
 * Serialization is the process of persisting an object from memory to a sequence of bits, like saving it to your disk.
 *
 */
public class Employee extends Person implements Serializable{

	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 9162467146664498506L;
	// DRY - Don't Repeat Yourself

	private String dept;
	
	public Employee() {
		
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
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
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		return true;
	}



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
	
	
	
}
