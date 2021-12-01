package com.revature.interactivearays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	// declare a  scanner as static member of this class
	
	private static Scanner scan = new Scanner(System.in); // cmd + shift + o to import;

	
	
	public static void main(String[] args) {
		
		int[] userNumbers = getIntegers(5);
		System.out.println(Arrays.toString(userNumbers));
		
		double avg = getAvgArray(userNumbers);
		System.out.println("Average is " + avg);
		
		

	}
	
	
	/**
	 * 1. create a method that does the following
	 * 
	 * - static method
	 * - return type is int[]
	 * - prompt the user to enter  a x numbers
	 * - stores those numbers in the array
	 */
	
	static int[] getIntegers(int capacity) {
		System.out.println("Please enter " + capacity + " integers");
		
		// initialize the array
		int []  numbers = new int[capacity];
		
		// create a for loop the array and each time the loop executes
		// capture the users input
		// within the array
		
		
		for (int i=0; i<numbers.length; i++) {
			// store the nextInt accepeted by scanner object and store it to index i of the array
			
			// to improve UX 
			System.out.println("Enter the " + (i + 1) + "th number");
			
			
			numbers[i] = scan.nextInt();
			
		}
		
		// return the array 
		// this is going back to main
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
	
	static double getAvgArray (int[] intArray) {
		int totalElements = intArray.length + 1;
		
		int total = 0;
		
		for (int i=0; i<intArray.length; i++) {
			total += intArray[i];
		}
		
		double avg = total / totalElements;
		return avg;
	}
	
	

}
