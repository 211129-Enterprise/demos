package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetStore {

	//Every PetStore has a DB which has a bunch of pet records in it
	//private List<Pet> petDB = new ArrayList<Pet>(); //Inferring generic via "<Pet>"
	//Array List implements List so it's legal to do above
	//ArrayList is a class implementation
	
	
	//by default, because we haven't specified a constructor here, there is a default constructor (no-args constructor)
	
	/*
	 * When I invoke the serialize method on a pet store object, 
	 * it will serialize the ArrayList of Pet objects to a file.
	 * 
	 * It will transform them to a bit stream and write it to a file.
	 * 
	 * This stream of bits can be re-hydrated — deserialization — at a later point in
	 * time by reading them from the file
	 */
	public void serialize() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))){
			
			//We are taking the petDB ArrayList of the
			//object that invokes this method and we're
			//writing it to a file.
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
		// This method is responsible for reading that byte stream and
		// creating a java object from the data inside of the file
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))){
			
			// Whenever a PetStore object calls this method, it SETS its petDB ArrayList
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
	
		
	private ArrayList<Pet> petDB = new ArrayList<Pet>();

	
	
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
