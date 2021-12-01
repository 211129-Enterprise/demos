package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetStore  {
	//every pet store has a database which has a bunch of pet records in it.
	private ArrayList <Pet> petDB = new ArrayList<Pet>();

	public ArrayList<Pet> getPetDB() {
		return petDB;
	}

	public void setPetDB(ArrayList<Pet> petDB) {
		this.petDB = petDB;
	}
	
	public void serialize() {
		try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
			//we are taking the petDB array list of the object that invokes this method
			//and writing it to a file
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

		@Override
		public String toString() {
			return "PetStore [petDB=" + petDB + "]";
		}
	
}
