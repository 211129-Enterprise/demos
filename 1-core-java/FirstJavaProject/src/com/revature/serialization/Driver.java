package com.revature.serialization;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		
//		Pet p1 = new Pet("Fluffy", 1004, "Cat", "Larry", 4, Color.GREY);
//		Pet p2 = new Pet("Spot", 1004, "Dog", "Jerry", 4, Color.GREY);
//
//		PetStore petco = new PetStore();
//		ArrayList<Pet> petcoDB = petco.getPetDB();
//		petcoDB.add(p1);
//		petcoDB.add(p2);
//		System.out.println(petcoDB);
//		petco.serialize();
		
		PetStore petsMart = new PetStore();
		petsMart.deserialize();
		System.out.println(petsMart);
		
	}

}
