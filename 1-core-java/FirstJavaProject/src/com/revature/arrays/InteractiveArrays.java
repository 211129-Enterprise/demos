package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	// declare a scanner as static member of this class
	private static Scanner scan = new Scanner(System.in); // ctrl + shift + O will import 

	public static void main(String[] args) {
		
		int[] userNumbers = getIntegers(5);
		//System.out.println(Arrays.toString(userNumbers));
		System.out.println(getAverage(userNumbers));
		printArray(userNumbers);

	}
	
	/**
	 *  Step 1. Create a method that does the following
	 *  
	 *  - static method 
	 *  - return type is int[]
	 *  - prompt the user to enter a x numbers
	 *  - stores those numbers in the array
	 */
	
	static int[] getIntegers(int capacity) {
		
		System.out.println("Please enter " + capacity + " integers");
		
		// initialize the array
		int[] numbers = new int[capacity];
		
		// create a for loop to loop the array and each timme the loop executes
		// it captures the user's input and saves that input to a slot
		// within the array
		for (int i=0; i<numbers.length; i++) {
			
			// store the nextInt accepted by the scanner object and save it to index i of the array'
			System.out.println("Enter the " +  (i + 1) + " number");
			numbers[i] = scan.nextInt();
			
		}

		// return  the array
		return numbers;
	}

	/*
	 * CHALLENGE:
	 * Create a static method that takes in an int array as a parameter.  It must return the average of all
	 * the elements within the array. (Make its return type a double).
	 * 
	 * Once you create this method, call it within the main method, and print its return, after passing through
	 * the array that was returned by the getIntegers method.
	 */
	

	
	static double getAverage(int[] array) {
		double aveCalculated = 0;
		
		for(int i = 0; i< array.length; i++)
			aveCalculated += array[i];
		aveCalculated = aveCalculated / array.length;
		
		return aveCalculated;
	}
	
	static void printArray(int[] array) {
		
		for(int i = 0; i< array.length; i++)
			System.out.println(array[i]);
		
	}
	
	
	
}
