package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.revature.models.Animal;

public class CollectionDriver {

	public static void main(String[] args) {
		
		
		/**
		 * List (Interface)
		 * 
		 * A list is an ordered collection (sometimes called a sequence).
		 * Lists may contain duplicate elements.
		 * It inherits some basic operations from the Collection interface.
		 * 
		 * ArrayList (one concrete implementation - implementation class)
		 * - retrieval - with O(1) with .get() method
		 * - Insertion/deletion - O(n)
		 * 
		 * LinkedList 
		 * - retrieval is O(n)
		 * - insertion/deletion is O(1)
		 */
		
		List<Integer> numbers = new ArrayList<Integer>(); // O(1) for retrieval, O(n) for insertion
		numbers = new LinkedList<Integer>(); // O(1) for insertion, O(n) for retrieval
		
		// build an ArrayList to hold ANimal objects
		List<Animal> animals = new ArrayList<>(); // post Java 7 you don't need to infer generics in class impl.
		
		
		// instantiate some Animals
		Animal a1 = new Animal("Tiger", 12);
		Animal a2 = new Animal("Dog", 4);
		Animal a3 = new Animal("Tiger", 12); // technically this is a duplicate object (even though object obj in the heap) becasue we overrode the hashcode and equals
		
		// add them to the list
		animals.add(a1);
		animals.add(a2);
		animals.add(a3); // a1 and a3 are considered duplicates
		
		for (Animal a : animals) {
			
			// print out each animal object's name
			// we set the properties to default so we can access them
			System.out.println(a.getName());
			
			
		}
		
		// find the 2nd element (index 1)
		Animal second = animals.get(1); // O(1) retrieval 
		
		System.out.println("========= SETS ===========");
		
		/**
		 * Set Interface
		 * 
		 * Unlike a List, a Set doesNOT maintain insertion order.
		 * It doesNOT allow duplicate elements.
		 */
		
		Set<Animal> animalSet = new HashSet<Animal>();
		
		
		
		animalSet.add(a1); // If this set already contains the element, the call leaves the set unchanged and returns false
		animalSet.add(a2);
		animalSet.add(a3);
		
//		if (!animalSet.add(a3)) { // check if the operation returns false
//			System.out.println("Hey you can't add duplicates!");
//		}
		

		for (Animal a : animalSet) {
			
			// print out each animal object's name
			// we set the properties to default so we can access them
			System.out.println(a.hashCode());
			
			
		}
		
		// One of the only ways to retrieve from a set.
		
		// How to iterate over a Set Better to just use a MAP!
		for (Iterator<Animal> it = animalSet.iterator(); it.hasNext(); ) {
			
			Animal a = it.next();
			
			if (a.equals(a2)) {
				System.out.println("found the dog");
			}
			
			
		}
		
	}

}
