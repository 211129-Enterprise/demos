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
		
		
		/*
		 * List
		 * 
		 * A List is an ordered Collection (sometimes called a sequence). Lists may contain duplicate elements.
		 * In addition to the operations inherited from Collection, the List interface includes operations for the following:
		 * 
		 * 		+ Positional access 
		 * 			— manipulates elements based on their numerical position in the list. This includes 
		 * 			  methods such as get, set, add, addAll, and remove.
		 * 
		 * 		+ Search 
		 * 			— searches for a specified object in the list and returns its numerical position. 
		 * 			  Search methods include indexOf and lastIndexOf.
		 * 
		 * 		+ Iteration 
		 * 			— extends Iterator semantics to take advantage of the list's sequential nature. 
		 * 			  The listIterator methods provide this behavior.
		 * 
		 * 		+ Range-view 
		 * 			— The sublist method performs arbitrary range operations on the list.
		 * 
		 * The Java platform contains two general-purpose List implementations. ArrayList, which performs well when adding or removing from 
		 * the collection frequently. A LinkedList which offers better performance when the collection will be accessed frequently (get and 
		 * set methods).
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
		
		/*
		 * Vector differs from ArrayList in 2 ways:
		 * 
		 * - Data Growth: A vector will double in size when it expands. (Whereas an ArrayList increases by 50%) 
		 * 
		 * - Synchronization: It's slower because it blocks multiple threads from using it at once. (locking).
		 * 		- If you're dealing with a multi-threaded program, and multiple threads are accessing one List,
		 * 		- you want to make sure it's a Vector.
		 */
		List<Integer> threadSafeNums = new Vector<Integer>();
		
		threadSafeNums.add(3);
		threadSafeNums.add(74);
		threadSafeNums.add(-9000);
		
		System.out.println(threadSafeNums);
		
		// find the 2nd element (index 1)
		Animal second = animals.get(1); // O(1) retrieval 
		
		/*
		 * Set
		 * 
		 * A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction. The Set 
		 * interface contains only methods inherited from Collection and adds the restriction that duplicate elements are 
		 * prohibited. 
		 * 
		 * Set also adds a stronger contract on the behavior of the equals and hashCode operations, allowing Set 
		 * instances to be compared meaningfully even if their implementation types differ. Two Set instances are equal if they 
		 * contain the same elements.
		 */
		
		System.out.println("==================== SETS BELOW =========================");
		
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
		
		/**
		 * Queue Interface
		 * 
		 * FIFO - first in first out
		 * allow for extra operations
		 * 
		 */
		
		Queue<Animal> animalQ = new LinkedList<Animal>();
		
		System.out.println("===== QUEUES ==========");
		
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);
		
		// build a while loop  - while the Q is not empty, we will remove the HEAD of the queue
		while (animalQ.size() != 0) {
			
			System.out.println("Queue Size " + animalQ.size());
			
			// we call .poll() method remove the head of the queue
			System.out.println("Processing.... " + animalQ.poll()); // .poll() will remove the head of the queue
			
			
		}
		
		// LIFO is the opposite
		// Last in, first out is thre order of operations for a Stack
		
		List<Integer> nums = new Vector<Integer>(); // thread safe array list

		nums.add(3);
		nums.add(1); // compiler is autoboxing the primitive values to Integer onbjects
		nums.add(2);
		
		// Collections is just a Class for manipulating Collections like Arrays class (utility class)
		System.out.println(nums);
		Collections.sort(nums); // sorts in ascending order based on natural order
		System.out.println("after sorting with Collections Utility Class");
		System.out.println(nums);

		
		
	}
	
}
