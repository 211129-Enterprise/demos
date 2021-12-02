package com.revature.models;

public class Animal {

		String name;
		int age;
		
		//Constructors from fields.
		public Animal(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		//Hashcode and equals
		@Override
		public String toString() {
			return "Animal [name=" + name + ", age=" + age + "]";
		}
		//getters/setters
		
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
