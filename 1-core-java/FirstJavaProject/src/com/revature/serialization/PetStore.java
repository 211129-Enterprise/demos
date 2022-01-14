package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PetStore {
	
	// Every PetStore has a DB which has a bunch of pet records in it
	private ArrayList<Pet> petDB = new ArrayList<Pet>(); // [___________]

	
	// by default because we haven;t specified a constructor here, there is a default construcotr( no-args constructor)
	
	/**
	 * When I invoke the serialize method on a pet Store object 
	 * it will serialize the ArrayList of Pet objects to a file
	 * 
	 * It will transform them to a bit stream and write it to a file.
	 * 
	 * This stream of bits can re0hydrated (deserialization) at a later point in
	 * time by reading from the file.
	 */
	public void serialize() {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
			
			// we are taking the petDB arraylist of the object that invokes this method
			// and writing it to a file
			oos.writeObject(this.getPetDB());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	@SuppressWarnings("unchecked") 
	public void deserialize() {
		// this method is responsible to reading that byte stream and
		// creating a java object from the data inside of the file 
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))) {
			
			// whenever a petStore object calls this method, it SETS it's petDB arraylist
			// EQUAL TO the info that's read from a file (in the form of a java object)
			this.setPetDB((ArrayList<Pet>) ois.readObject());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public ArrayList<Pet> getPetDB() {
		return petDB;
	}

	public void setPetDB(ArrayList<Pet> petDB) {
		this.petDB = petDB;
	}

	@Override
	public String toString() {
		return "PetStore [petDB=" + petDB + "]";
	}

}
