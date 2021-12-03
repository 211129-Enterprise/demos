package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Animal;

public class CollectionDriver {

	public static void main(String[] args) {
		/*
		 * List (Interface)
		 * 
		 * A list is an ordered collection (sometimes called a sequence)
		 * Lists may contain duplicate elements.
		 * 
		 * It inherits some basic operations from the Collection interface
		 * 
		 * ArrayList (one concrete implementation - implementation class)
		 *     search with O(1) with .get() method
		 *     Insertion/removal - O(n) 
		 *     
		 * LinkedList
		 * - retrieval is O(n)
		 * - insertion/deletion is O(1)
		 */
		
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers = new LinkedList<Integer>();
		
		
		List<Animal> animals = new ArrayList<>();
		
		
		
		Animal a1 = new Animal("Tiger", 12);
		
		Animal a2 = new Animal("Dog", 4);
		
		Animal a3 = new Animal("Tiger", 12);
		
		animals.add(a1);
		
		animals.add(a2);
		
		animals.add(a3);
		
		for (Animal a : animals) {
			System.out.println(a.getName());
		}
		
		Animal second = animals.get(1); // O(1) retrieval
		
		
	}

}
