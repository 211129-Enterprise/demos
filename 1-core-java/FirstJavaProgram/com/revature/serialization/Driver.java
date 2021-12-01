package com.revature.serialization;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
//		//Instantiate some Pet Objects
//		Pet p1 = new Pet("Fluffy", "Cat", "Owner", 1004, 4, Color.GREY);
//		Pet p2 = new Pet("Spot", "Dog", "Jerry", 2293, 1, Color.BROWN);
//		
//		PetStore petco = new PetStore();
//		
//		//we want to capture the array list that is the
//		//petDB and add some pets to it.
//		ArrayList<Pet> petcoDB = petco.getPetDB(); // [________]
//		
//		petcoDB.add(p1); // [_p1_____]
//		petcoDB.add(p2); // [_p1__p2_]
//		
//		for(Pet p : petcoDB) {
//			System.out.println(p);
//		}
//		
//		
//		petco.serialize(); //This should write the ArrayList complete with 2 pets to a file
		
		
		//Instantiate a new Pet Store that will deserialize the object and adopt that collection as its own
		PetStore petsMart = new PetStore();
		petsMart.deserialize(); // This will read from the file and deserialize (hydrate) those objects (instantiate them)
		
		System.out.println(petsMart.getPetDB());
	}
}
