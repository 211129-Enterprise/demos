package com.revature.models;

import java.util.Objects;

// remember that custom classes inherit from java.lang.Object class
public class Person { // POJO = Plain Old Java Object

	
	// properties (states)
	
		//instance variables - properties specific to each instance of a person that is instantiated
		private String name;
		private int age;
		private double height;
		private double weight;
		
		// constructors
		//no args constructor that creates an empty person
		public Person() {
			
		}
		//name only constructor that only takes in and assigns name, it assigns it to the name field and leaves the others blank
		public Person(String name) {
			super(); // calling the object class or direct parent class
			this.name = name;
		}
		// full constructor for all fields the person has, it takes in and assigns values for each field.
		public Person(String name, int age, double height, double weight) {
			super();
			this.name = name;
			this.age = age;
			this.height = height;
			this.weight = weight;
		}
		
		
		// must have getters and setters to change and access private variables created from this class.
		// to generate these right click => source => generate getters and setters.
		// methods (behaviors)
		public void introduction() {
			System.out.println("My name is " + name);
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
		public double getHeight() {
			return height;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(age, height, name, weight);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			return age == other.age && Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
					&& Objects.equals(name, other.name)
					&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
		}
	
		
		// we can override a method that we inherit
		
		
		
		
		
}
