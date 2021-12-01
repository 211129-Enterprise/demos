package com.revature.serialization;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		//Instantiate a pet
//		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.Grey);
//		Pet p2 = new Pet("Spot", 2203, "Dog", "Jerry", 4, Color.Brown);
//		
//		PetStore petco = new PetStore();
//		//we want to capture the array list that is the petDB and add some pets to it.
//		ArrayList<Pet> petcoDB = petco.getPetDB();
//		petcoDB.add(p1); 
//		petcoDB.add(p2);
//		
//		//System.out.println(petcoDB); //non fancy way of running
//		for (Pet p : petcoDB) { //For each pet of the collection, print it out.
//			System.out.println(p); //this prints pets on different lines. Best way!
//		}
//		
//		petco.serialize(); //This should write the arrayList (complete with 2 pet files.)
		PetStore petsMart = new PetStore();
		petsMart.deserialize();
		
		System.out.println(petsMart.getPetDB());
		

	}
	
	
}
