package com.revature.serialization;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		
		// instantiate a Pet
		
		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.GREY);
		
		Pet p2 = new Pet("spot", 2003, "Dog", "Jerry", 1, Color.BROWN );
		
		PetStore petco = new PetStore() ; 
		// we want to capture the array list that is the pet DB an ad some pets to it
		
		ArrayList<Pet> petcoDB = petco.getPetDB();
		
		petcoDB.add(p1);
		petcoDB.add(p2);
		
		System.out.println(petcoDB);
		

	}

}
