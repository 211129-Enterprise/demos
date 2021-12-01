package com.revature.serialization;

import java.io.Serializable;
import java.util.Objects;

/*
 * Java Bean
 * -- Private instance variables
 * -- Getters / Setters
 * -- Overidden hashcode and equals
 * -- implements serializable interface
 * -- no-args constructor
 */
public class Pet implements Serializable{

/* PRIVATE INSTANCE VARIABLES */
	private String name, breed, owner;
	private int tagNumber, age;
	private Color color; //brown, grey, black, white
	
	
/* CONSTRUCTORS */
	//NO-ARGS constructor
	public Pet() {
		
	}

	//FULLY PARAMETERIZED constructor
	public Pet(String name, String breed, String owner, int tagNumber, int age, Color color) {
		super();
		this.name = name;
		this.breed = breed;
		this.owner = owner;
		this.tagNumber = tagNumber;
		this.age = age;
		this.color = color;
	}


/* GETTERS AND SETTERS */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public int getTagNumber() {
		return tagNumber;
	}


	public void setTagNumber(int tagNumber) {
		this.tagNumber = tagNumber;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	
	
	
/* HASHCODE & EQUALS OVERRIDE */
	@Override
	public int hashCode() {
		return Objects.hash(age, breed, color, name, owner, tagNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return age == other.age && Objects.equals(breed, other.breed) && color == other.color
				&& Objects.equals(name, other.name) && Objects.equals(owner, other.owner)
				&& tagNumber == other.tagNumber;
	}

/* TO-STRING OVERRIDE */
	@Override
	public String toString() {
		return "Pet [name=" + name + ", breed=" + breed + ", owner=" + owner + ", tagNumber=" + tagNumber + ", age="
				+ age + ", color=" + color + "]";
	}	

}


