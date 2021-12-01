package com.revature.serialization;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Petstore {
	// Every store has a DB which has bunch of records in it
	
	private ArrayList<Pet> petDB = new ArrayList<Pet>();

	// ArrayList is a class implementation
	
	public void serialize() {
		/**
		 * Goal is when called on Petstore object it serialize the arraylist of Pet ojects to a file
		 * 
		 * it will tranform to bit stream and write to file
		 * 
		 * this bit stream can be rehydrated at later point
		 * 
		 * 
		 */
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStrean("files/pet.db"))) {
			
		} 
	}
	
	public void deserialize () {
		
		try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("files/pet.db")))
	}
	
}
