package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	// declare a scanner as a static member of this class
	private static Scanner scan = new Scanner(System.in); // ctrl + shift + O will import
	
//	public static void main(String[] args) {
//		
//		int[] userNumbers = getIntegers(5);
//		System.out.println(Arrays.toString(userNumbers));
//		
//		System.out.println("The average of the the numbers is " + averager(userNumbers));
//		
//	}
	
	public static void main(String[] args) {
		
		int[] userNumbers = getIntegers(5);
		printArray(userNumbers);
		
		System.out.println("The average of the numbers is " + averager(userNumbers));
	}
	
	
	/* Step 1. Create a method that does the following:
	 * 
	 *  - static method
	 *  - return type is int[]
	 *  - prompt the user to enter x numbers
	 *  - stores those numbers in the array
	 * 
	 */
	
//	static int[] getIntegers(int capacity) {
//		
//		System.out.println("Please enter " + capacity + " integers");
//		
//		// initialize the array
//		int[] numbers = new int[capacity];
//		
//		// create a for loop to loop the array and each time the loop executes
//		// it captures the user's input and saves that input to a slot
//		// within the array
//		for (int i=0; i< numbers.length; i++) {
//			
//			// store the nextInt accepted by the scanner object and save it to index i of the array
//			System.out.println("Enter the " + i + " number");
//			numbers[i] = scan.nextInt();
//			
//		}
//	
//		// return the array
//		return numbers;
//	}
	
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
	
	static double averager(int[] numbers) {
		
		// I will need a for loop to iterate through the entire array
		// I will need to record the sum of all numbers I'm iterating through the array
		
//		double avg = 0;
		double sum = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			
//			sum = sum + numbers[i];
			sum += numbers[i];
		}
		
//		avg = sum / numbers.length;
//		return avg;
		
		return sum / numbers.length;
		
	}
	
	static void printArray(int[] arr) {
		
		for (int n : arr) {

			System.out.println(n);
		}
	
	}
	
	/*
	 * CHALLENGE:
	 * Create a static method that takes in an int array as a parameter.  It must return the average of all
	 * the elements within the array. (Make its return type a double).
	 * 
	 * Once you create this method, call it within the main method, and print its return, after passing through
	 * the array that was returned by the getIntegers method.
	 */
	
}
