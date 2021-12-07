package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

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
		
		Animal second = animals.get(1); // O(1) retrieval - never gets more complex - linear time complexity
		
		
		/*
		Set Interface
		
		unlike a list, a set does not maintain insertion order.
		it does not allow duplicate elements
	*/
		
		Set<Animal> animalSet = new HashSet<Animal>();
		
//		animalSet.add(animalSet);
		
		
		
		/*
		 * Queue Interface
		 * 
		 * FIFO = first in first out
		 * allow for extra operations
		 * 
		 */
		
		Queue<Animal> animalQ = new LinkedList<Animal>();
		
		System.out.println("====== Queues ======");
		
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);
		
		while (animalQ.size() != 0) {
			System.out.println("Queue Size " + animalQ.size());
			
			System.out.println("Processing...." + animalQ.poll());
		}
		// a Vector is a thread safe arraylist
		List<Integer> nums = new Vector<Integer>();
		
		nums.add(1); // compiler is autoboxing the primitive values to Integer objects
		nums.add(2);
		nums.add(3);
		
		System.out.println(nums);
		
		Collections.sort(nums); // sorts in ascending order based on natural order
		
		System.out.println("after sorting with collections utility class");
		
		System.out.println(nums);
	}

}
