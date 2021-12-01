//package com.revature.serialisation;
///*
// * Java bean
// * 
// * -private instance 
// * -getter and setter
// * - ovride equls and hashcode
// * -implements serializable interface 
// * 
// */
//
//import java.io.Serializable;
//import java.util.Objects;
//
//import javax.swing.text.AttributeSet.ColorAttribute;
//
//public class Pet implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private String name;
//	private int tagNumber;
//	private String breed;
//	private String owner;
//	private int age ; 
//	private Color color;
//	
//	public Pet(){
//		
//	}
//
//	public Pet(String name, int tagNumber, String breed, String owner, int age, Color color) {
//		super();
//		this.name = name;
//		this.tagNumber = tagNumber;
//		this.breed = breed;
//		this.owner = owner;
//		this.age = age;
//		this.color = color;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getTagNumber() {
//		return tagNumber;
//	}
//
//	public void setTagNumber(int tagNumber) {
//		this.tagNumber = tagNumber;
//	}
//
//	public String getBreed() {
//		return breed;
//	}
//
//	public void setBreed(String breed) {
//		this.breed = breed;
//	}
//
//	public String getOwner() {
//		return owner;
//	}
//
//	public void setOwner(String owner) {
//		this.owner = owner;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public Color getColor() {
//		return color;
//	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(age, breed, color, name, owner, tagNumber);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Pet other = (Pet) obj;
//		return age == other.age && Objects.equals(breed, other.breed) && color == other.color
//				&& Objects.equals(name, other.name) && Objects.equals(owner, other.owner)
//				&& tagNumber == other.tagNumber;
//	}
//
//	@Override
//	public String toString() {
//		return "Pet [name=" + name + ", tagNumber=" + tagNumber + ", breed=" + breed + ", owner=" + owner + ", age="
//				+ age + ", color=" + color + "]";
//	}
//
//	
//	
//	
//}


package com.revature.serialisation;

import java.io.Serializable;
import java.util.Objects;

/**
 * Java Beans
 * 
 * - private instnace variables
 * - getters/setters
 * - overidden haschode and equals
 * - implements serializable interface 
 * - no-args constructor
 */
public class Pet implements Serializable {
	
	private String name;
	private int tagNumber;
	private String breed;
	private String owner;
	private int age;
	private Color color;// brown, grey, black, white
	
	// no-args constructor (also called default constructor)
	public Pet() {
		
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

	@Override
	public String toString() {
		return "Pet [name=" + name + ", tagNumber=" + tagNumber + ", breed=" + breed + ", owner=" + owner + ", age="
				+ age + ", color=" + color + "]";
	}
	
	// alt + shift + S > hashCode & equals()
	
	

}
