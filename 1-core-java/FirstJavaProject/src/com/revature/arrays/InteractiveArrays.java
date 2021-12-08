package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
<<<<<<< HEAD

	private static Scanner scan = new Scanner(System.in);
		
	public static void main(String[] args) {
		
		System.out.println("Please Enter the length of your array: ");
		int arrLength = scan.nextInt();
		
		int[] userNumbers = getIntegers(arrLength);
		System.out.println(Arrays.toString(userNumbers));
		System.out.println();
		
		double userAverage = calcAverage(userNumbers);
		System.out.println("your average is: "+ userAverage);
		
			
		}
	
=======
	
	// declare a scanner as static member of this class
	private static Scanner scan = new Scanner(System.in); // ctrl + shift + O will import 

	public static void main(String[] args) {
		
		int[] userNumbers = getIntegers(5);
//		System.out.println(Arrays.toString(userNumbers));
		printArray(userNumbers);
		
		double avg = getAverage(userNumbers);

		System.out.println("the average was " + avg);
		
	}
	
	/**
	 *  Step 1. Create a method that does the following
	 *  
	 *  - static method 
	 *  - return type is int[]
	 *  - prompt the user to enter a x numbers
	 *  - stores those numbers in the array
	 */
>>>>>>> 0bca53b785f2de35fc67962dfe9e69979522c923
	
	static int[] getIntegers(int capacity) {
		
		System.out.println("Please enter " + capacity + " integers");
		
		// initialize the array
		int[] numbers = new int[capacity];
		
<<<<<<< HEAD
		// create a for loop to loop the array and each timme the loop executes
=======
		// create a for loop to loop the array and each time the loop executes
>>>>>>> 0bca53b785f2de35fc67962dfe9e69979522c923
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
<<<<<<< HEAD
	
	static double calcAverage(int[] numbersArr) {
		double average;
		
		double sum = 0;
		
		for(int i=0; i < numbersArr.length; i++) {
			sum = sum + numbersArr[i];
		}
		
		average = sum/numbersArr.length;
		
		return average;
	}
=======

	/*
	 * CHALLENGE:
	 * Create a static method that takes in an int array as a parameter.  It must return the average of all
	 * the elements within the array. (Make its return type a double).
	 * 
	 * Once you create this method, call it within the main method, and print its return, after passing through
	 * the array that was returned by the getIntegers method.
	 * 
	 * BONUS: can you create another method that prints out the array so we don't have to always call the Arrays.toString method?
	 */
	static double getAverage(int[] arr) {
		// I will need a for loop to iterate thru the entire array
		// I need to record a SUM of all the numbers I'm iterating through
		// I need to make sure I capture the lenght (the number of elements within the array)
		
		double sum = 0;

		// if my array's capacity is 4...the lenght is 4...[ _0_, 1, 2, 3]
		for (int i=0; i<arr.length; i++) {
			
//			sum = sum + arr[i];
			sum += arr[i]; // this is short hand 
		}
		
		double avg = sum/arr.length;
		
		return avg;
		
	}
	
	static void printArray(int[] arr ) {
		
		for (int n : arr) {
			
			System.out.println(n);
		}
		
	}
	
	
	
	
	
	
	
>>>>>>> 0bca53b785f2de35fc67962dfe9e69979522c923
}
