package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	//Declare a scanner as a static member of this class
	private static Scanner scan = new Scanner(System.in); //Control + shift + O will import java.util.Scanner
	//Better practice to make it private so you can't access it outside this class (but can be accessed within class)
	//Also worth noting that this makes it more difficult to close because closing inside a method would...
	//...make it difficult for other methods to use it too

	public static void main(String[] args) {
		
		int[] userNumbers = getIntegers(5);
		//System.out.println(Arrays.toString(userNumbers));
		printArray(userNumbers);
		
		double userNumbersAverage = getAverageFromArray(userNumbers);
		
		System.out.println("The average of the given numbers is: " + userNumbersAverage);

	}
	
	/*
	 * Step 1. Create a method that does the follow:
	 * 
	 *  - static method
	 *  - return type is int[]
	 *  - purpose is to prompt the user to enter x numbers
	 *  - stores those numbers in the array
	 */
	
	static int[] getIntegers(int capacity) {
		System.out.println("Please enter " + capacity + " integers.");
		
		//Initialize the array
		int[] numbers = new int[capacity];
		
		//Create a for loop to loop through the array
		//and capture user input each iteration and saves
		//the input to a slot within the array
		for(int i = 0; i < numbers.length; i++) {
			
			System.out.print("Please enter the number " + (i + 1) + ": ");
			//Store the nextInt accepted by the scanner object and save it to index i of the array
			numbers[i] = scan.nextInt();
			
		}
		
		
		//return the array		
		return numbers;
	}
	
	
	
	/*
	 * CHALLENGE:
	 * Create a static method that takes in an int array as a parameter. 
	 * It must return the average of all the elements within the array. 
	 * Make its return type a double.
	 * 
	 * Once you create this method, call it within the main method, and print its return, after passing through
	 * the array that was returned by the getIntegers method.
	 * 
	 * BONUS: See if you can create another method that prints out an array so we don't have to always call
	 * 		  the Arrays.toString method.
	 */
	static double getAverageFromArray(int[] sourceArr) {
		
		//Initialize length and sum
		double arrLength = sourceArr.length, 
			   arrSum = 0;
		
		//Get sum from the array
		for(int i = 0; i < arrLength; i++) {
			arrSum += sourceArr[i];
		}
		
		//Calculate and return the average
		return (arrSum / arrLength);
	}
	

	//BONUS: Methods to print out array
	static void printArray(int[] arr) {
		System.out.print("You entered:");
		
		for(int n : arr) {
			System.out.print( " " + n);
		}
		
		System.out.println(".");
	}
	static void printArray(double[] arr) {
		System.out.print("You entered: ");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(" " + arr[i]);
		}
		
		System.out.println(".");
	}

}
