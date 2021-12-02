package com.revature.serialization;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
//		// instantiate some Pet Objects
//		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.GREY);
//		Pet p2 = new Pet("Spot", 2203, "Dog", "Jerry", 1, Color.BROWN);
//		
//		PetStore petco = new PetStore();
//		// we want to capture the array list that is the petDB and add some pets to it.
//		ArrayList<Pet> petcoDB = petco.getPetDB();
//		
//		petcoDB.add(p1);
//		petcoDB.add(p2);
//		
////		System.out.println(petcoDB);
//		for (Pet p : petcoDB) {
//			System.out.println(p);
//		}
//		
//		petco.serialize(); // this should write the ArrayList (complete with 2 pets to a file)
//		
		
		// instantiate a new Pet Store that will deserialize that object and adopt that collection as its own
		PetStore petsMart = new PetStore();
		petsMart.deserialize(); // this will read from the file and deserialize (hydrate) those objects
		System.out.println(petsMart.getPetDB());
		
		
	}
	
}
