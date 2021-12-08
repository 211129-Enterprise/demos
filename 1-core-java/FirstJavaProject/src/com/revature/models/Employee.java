package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * Inheritance in Java is the concept that allows classes to acquire proerties
 * from other classes, like a son inherits properties father;
 * 
 * Abstraction - The process of hiding data that's not necessary to view.
 * 
 * We will make Employee Class a Java Bean
 * 
 * -- all instance variable are private 
 * -- it is serializable 
 * -- it has overridden hashCode and Equals
 * -- getters & setters
 * 
 * Serialization is the process of persistein gan object from memory to a
 * sequence of bits, like saving it to your disk.
 * 
 * WHat is the difference between  a Java Bean vs a POJO?
 */
public class Employee extends Person implements Serializable {

	/**
	 * serialVersionUID is a unique identifier for each class
	 */
	private static final long serialVersionUID = 9162467146664498506L;
	// DRY - Don't Repeat Yourself

	private String dept;

	public Employee() {
		
	}
	
	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight);
		this.dept = dept;
	}

	// all the getters & setters are still available to us due to inhertiance from
	// the parent class, yet are abstracted away from us

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
