package com.revature.searching;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Animal;

public class AlgorithmDriver {

	public static void main(String[] args) {
		
		//What linear and binary will be working with
		int[] arr = {1, 3, 23, 52, 64, 65, 66, 89};
		int target = 65;
		
		//Which will take LESS operations to find the target 65 in the given sorted array?
		linearSearch(arr, target); //Will run 6 operations to locate 6th position
		
		System.out.println("=========================================================");
		
		binarySearch(arr, target); //Will run 2 operations as it operates in O(log n) aka Logarithmic time Complexity.
		
		System.out.println("=========================================================");
		
		List<Animal> animals = new ArrayList<Animal>();
		
		// Instantiate some animals
		Animal a1 = new Animal("Tiger", 12);
		Animal a2 = new Animal("Dog", 4);
		Animal a3 = new Animal("Wulf", 10); // Technically this is a duplicate object (even though object obj in the heap) 
											 // because we overrode the hashCode and equals

		//add them to the list
		animals.add(a1);
		animals.add(a2);
		animals.add(a3);
	}
	
	/*
	 * LINEAR SEARCH
	 * O(n) linear time complexity
	 */
	private static int linearSearch(int[] arr, int target) {
		
		//Iterate through EACH number within the array and check if it's the target value
		for(int i = 0; i < arr.length; i++) {
			
			System.out.println("Loop " + i + ": searching for target..."); //Everytime we perform an operation, this will print out
			
			if(arr[i] == target) {
				System.out.println("Found " + target + " at index " + i);
				return i;
			}
		}
		
		return -1;//return -1 if it doesn't find the target
	}
	
	/*
	 * BINARY
	 * Operates in logarithmic time
	 */
	private static int binarySearch(int[] arr, int target) {
		
		int min = 0, max = arr.length - 1;
		
		while(min <= max) {
			
			System.out.println("Searching...");
			
			int mid = (min + max) / 2; //finding the middle index
			
			//If the target is less than the mid point at the middle index,
			//discard the RHS (Right Hand Side) of the array
			if(target < arr[mid]) {
				max = mid - 1; //discard the RHS (Right Hand Side) of the array
				
				
			//If the target is greater than the mid point at the middle index,
			//then we discard the LHS (Left Hand Side) of the array
			} else if(target > arr[mid]) {
				min = mid + 1; //discard LHS (Left Hand Side)
				
				
			} else {
				System.out.println("Found " + target + " at index " + mid);
				return mid; //return the mid as the index position of where we found our target element
			}
		}
		
		return -1;//return -1 if it doesn't find the target
	}
}