package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PetStore {
	private ArrayList<Pet> petDB = new ArrayList<Pet>();
	
	public void serialize() {
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
        	 oos.writeObject(this.getPetDB());
         } catch(FileNotFoundException e) {
        	 e.printStackTrace();
         } catch (IOException e) {
        	 e.printStackTrace();
         }
	}
	
	public void deserialize() {
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))) {
			 this.setPetDB((ArrayList<Pet>) ois.readObject());
         } catch (ClassNotFoundException e) {
		     e.printStackTrace();
         } catch(FileNotFoundException e) {
        	 e.printStackTrace();
         } catch (IOException e) {
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
