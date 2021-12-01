package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetStore {
	
	// Every pet store has a database which has a bunch of pet records in it
	private List<Pet> petDB = new ArrayList<Pet>();
	
	public void serialize() {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
			
			// taking the petDB arraylist and writing it to a file
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
	public void deserialize() throws ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))) {
			
			this.setPetDB((ArrayList<Pet>) ois.readObject());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Pet> getPetDB() {
		return petDB;
	}

	public void setPetDB(List<Pet> petDB) {
		this.petDB = petDB;
	}

	@Override
	public int hashCode() {
		return Objects.hash(petDB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetStore other = (PetStore) obj;
		return Objects.equals(petDB, other.petDB);
	}

	@Override
	public String toString() {
		return "PetStore [petDB=" + petDB + "]";
	}

}
