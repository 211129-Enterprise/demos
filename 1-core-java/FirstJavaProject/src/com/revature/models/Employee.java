package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = 4267462985081643159L;
	private String dept;
	
	public Employee() {
		super();
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
