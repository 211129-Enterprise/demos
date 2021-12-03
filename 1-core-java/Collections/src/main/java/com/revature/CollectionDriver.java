package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

import com.revature.models.Animal;

public class CollectionDriver {

	public static void main(String[] args) {
		
		/**
		 * List (Interface)
		 * > A list is an ordered collection, sometimes called a sequence
		 * > It may contain duplicate elements
		 * > It inherits some basic operations from the Collection interface
		 * 
		 * 
		 * ArrayList (One concrete implementation - implementation class)
		 * 	- retrieval - with O(1) with .get() method [CONSTANT]
		 *  - insertion / removal - O(n) [LINEAR]
		 *  
		 *  
		 *  LinkedList
		 *  - retrieval is O(n) [LINEAR]
		 *  - insertion / deletion is O(1) [CONSTANT]
		 */
		List<Integer> numbers = new ArrayList<Integer>();
		numbers = new LinkedList<Integer>();
		
		// build an ArrayList to hold animal objects
		List<Animal> animals = new ArrayList<Animal>();
		
		Animal a1 = new Animal("Tiger", 12);
		Animal a2 = new Animal("Dog", 4);
		Animal a3 = new Animal("Tiger", 12); // Technically this is a duplicate object (even though object obj in the heap) 
											 // because we overrode the hashCode and equals

		//add them to the list
		animals.add(a1);
		animals.add(a2);
		animals.add(a3);
		
		for(Animal a : animals) {
			
			//print out each object's name
			//we set the properties to default so we can access them
			System.out.println( a.getName() );
			
		}
		
		// Find the second element (Index 1)
		Animal second = animals.get(1); // O(1) retrieval - CONSTANT Time Complexity
										// Would never change in time complexity no matter how big the array list is
		System.out.println("================== SETS ==================");
		
		/**
		 * Set Interface
		 * 
		 * Unlike a list, a Set does NOT maintain insertion order.
		 * It does NOT allow duplicate elements.
		 */
		
		Set<Animal> animalSet = new HashSet<Animal>();
		
		animalSet.add(a1); //If this set already contains the element, the call leaves the set unchanged and returns false
		animalSet.add(a2); 
		
		if(!animalSet.add(a2)) { //Check if operation returns false 
			System.out.println("Hey, you can't add duplicates!");
		}
		
		for(Animal a : animalSet) {
			
			//Print out each animal's object name
			//We set the properties to default so we can access them
			System.out.println(a.hashCode());
		
		}
		
		
		// better to just use a MAP, but here is...
		// ...how to retrieve from a set using an iterator:
		for( Iterator<Animal> it = animalSet.iterator(); it.hasNext(); ) {
			
			Animal a = it.next();
			
			if(a.equals(a2)) {
				System.out.println("Found the dog!");
			}
		
		}
		
		/**
		 * Queue Interface
		 * FIFO - First in, first out
		 * Allow for extra operations
		 */
		
		Queue<Animal> animalQ = new LinkedList<Animal>();
		
		System.out.println("===== QUEUES =====");
		
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);
		
		//build a while loop - while the queue is not empty, we'll remove the HEAD of the queue
		// * Poll releases object from data structure *
		while(animalQ.size() != 0) {
			System.out.println("Queue Size: " + animalQ.size());
			
			//We'll call the .poll method to remove the head of the queue
			System.out.println("Processing..." + animalQ.poll()); //.poll() will remove the head of the queue
			
			
		}
		
		//LIFO - Last in, First out
		//The order of operations for a stack
		
		List<Integer> nums = new Vector<Integer>(); //Thread safe array list
		
		nums.add(3);
		nums.add(1); //Compiler is autoboxing the primitive values to
		nums.add(2); //integer objects
		
		//Collections is just a class for manipulating collections like Arrays class (utility class)
		System.out.println(nums);
		Collections.sort(nums); //Always sorts in ascending order based on natural order
		System.out.println("After sorting with the collections utility class...");
		System.out.println(nums);
		
	}

}
