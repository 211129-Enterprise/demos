package com.revature.models;

// Comparable Interface is a functional Interface meaning you implement it to implement ONE method
// That one method defined how to order your objects of this user-defined class.

// Now if I want to perform a binary search on a list of animals
// as long as those objects implement Comaprable, they can be processed by the method
// in order to understand Target is animal is > or < the Animal at the mid point
public class Animal implements Comparable<Animal>{
	
	String name;
	int age;
	
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	@Override // returns 0, 1, or -1 
	public int compareTo(Animal animal) {
		// TODO Auto-generated method stub
		return this.name.compareToIgnoreCase(animal.getName());
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
}
