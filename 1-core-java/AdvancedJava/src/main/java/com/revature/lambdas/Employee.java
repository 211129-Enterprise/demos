package com.revature.lambdas;

import java.util.Objects;

//POJO
public class Employee {
	private String name;
	private int age;
	
	//no args constructor if it were a java bean / serializable.
	
	//toString method == ====================================================================================================
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//Getters and Setters ====================================================================================================
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//Hash code and equals ====================================================================================================
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	
	
	
}
