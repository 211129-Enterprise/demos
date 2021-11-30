package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * Inheritance in Java is the concept that allows classes to acquire properties from other classes, 
 * like a son inherits properties from a father
 * 
 * Abstraction THe process of hiding data that's not necessary to view. 
 * In other words, it's the concept that you don't need to know how it works in order to use it
 * 
 * We will make the Employee Class a Java Bean
 * --All instance variables are private
 * --It is serializable (convert to stream of bits for storage)
 * --It has overridden hashCode and Equals
 * 
 * Serialization is the process of perstient object from memory to a sequence of bits, like saving it to your disk
 * 
 * What is the difference between a Java Bean and a POJO?
 * https://stackoverflow.com/questions/1394265/what-is-the-difference-between-a-javabean-and-a-pojo
 */
public class Employee extends Person implements Serializable{

	/**
	 * serialVersionUID is a unique identifier for each class
	 */
	private static final long serialVersionUID = 916246716664498506L;
	
	
	//DRY - Don't Repeat Yourself
	//name
	//age
	//height
	//weight
	
	// + department
	private String dept; //"Starting getting in the habit of making instance variables private"
	
	//Constructor
	public Employee() {
	
	}
	
	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight);
		this.dept = dept;
	}
	
	//All the getters and setters are still available to us due to inheritance from the parent class yet are still abstracted away from us
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
