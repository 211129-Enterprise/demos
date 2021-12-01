package com.revature.serialization;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// Instantiate some pet objects
//		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.GREY);
//		Pet p2 = new Pet("Spot", 2203, "Dog", "Jerry", 1, Color.BROWN);
//		
//		
//		PetStore petco = new PetStore();
//		// we want to capture the array list that is petDB and add some pets to it
//		ArrayList<Pet> petcoDB = petco.getPetDB();
//		
//		petcoDB.add(p1);
//		petcoDB.add(p2);
//		
//		for(Pet p : petcoDB) {
//			System.out.println(p);
//		}
//		
//		
//		petco.serialize(); // this should write the array list (complete with 2 pets) to a file.

		PetStore petsMart = new PetStore();
		
		petsMart.deserialize(); // This will read from the file and deserialize (hydrate) those objects
		
		System.out.println(petsMart.getPetDB());
		
		
	
	}

}
