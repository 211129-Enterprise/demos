package com.revature.serialization;

import java.io.Serializable;
import java.util.Objects;

/**
 * Java Beans
 * 
 * - Java Beans have private instance variables
 * - getter/setters
 * - overidden hashcode
 * - implements serializable interface
 * - no-args constructor
 *
 */
public class Pet implements Serializable {
	
	private String name;
	private int tagNumber;
	private String breed;
	private String owner;
	private int age;
	
	// pet color can only be brown, grey, black and white
	
	private Color color;// brown, grey, black, white // this is called enum
	
	// no args constructor
	public Pet () {
		
	}

	// fully parameterized constructor
	public Pet(String name, int tagNumber, String breed, String owner, int age, Color color) {
		super();
		this.name = name;
		this.tagNumber = tagNumber;
		this.breed = breed;
		this.owner = owner;
		this.age = age;
		this.color = color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getTagNumber() {
		return tagNumber;
	}


	public void setTagNumber(int tagNumber) {
		this.tagNumber = tagNumber;
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
	
	

}
