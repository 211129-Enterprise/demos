package com.revature.searching;

<<<<<<< HEAD
public class AlgorithmDriver {
	public static void main(String[] args) {
		
	}
=======
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Animal;

public class AlgorithmDriver {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 4, 23, 52, 64, 65, 66, 89}; // sorted array 
		
		int target = 65;
		
		// which will take LESS operations to find the target 65 in the given, sorted array
		linearSearch(arr, target); // will run 6 operations to locate 6th position
		
		System.out.println("=========================");
		
		binarySearch(arr, target); // O(log n) - Logarithmic Time Complexity
		
		List<Animal> animals = new ArrayList<Animal>();
		
		// instantiate some Animals
		Animal a1 = new Animal("Tiger", 12);
		Animal a2 = new Animal("Dog", 4);
		Animal a3 = new Animal("Wolf", 10); // technically this is a duplicate object (even though object obj in the heap) becasue we overrode the hashcode and equals
		
		// add them to the list
		animals.add(a1);
		animals.add(a2);
		animals.add(a3); // a1 and a3 are considered duplicates
		
		
		
	}

	// binary 
	private static int binarySearch(int[] arr, int target) {
		
		int min = 0;
		int max = arr.length - 1; // the last index
		
		while (min <= max) {
			
			System.out.println("searching.....");
			
			int mid = (min + max) / 2; // finding the middle index
			
			// if the target is less than the the element at the middle index,
			if (target < arr[mid] ) {
				max = mid - 1; // discard the RHS (Right Hand Side) of the array
			} else if (target > arr[mid]) { // if the target is greater than the element at the middle index then we discard the LHS
				min = mid + 1; // discard LHS				
			} else {
				System.out.println("found " + target + " at index " + mid);
				return mid; // return the mid as the index position of where we found our target element 
			}
		}	
		return -1; // if it doesn't exist then it will return -1;
	}
	

	
	// linear search - O(n) Linear Time complexity 
	private static int linearSearch(int[] arr, int target) {
		
		
		// iterate through EACH number within the array, and check if it's the target value
		for (int i =0; i < arr.length; i++) {
			
			System.out.println("searching....."); // everytime we perform an operation, this will print out
			
			if (arr[i] == target) {
				System.out.println("found " + target + " at index " + i);
				return i;
			}
			
		}
		return -1; // return -1 if it doesn't find the target
		
	}
	
	
	
>>>>>>> f3f3f52fd33d8857a40e61cc42c0f040b8df97ac
}
