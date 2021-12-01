package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	static Scanner scan =new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] userNumbers = getIntegers(5);
		System.out.println(Arrays.toString(userNumbers));
		//call the method for average in the main method.
		double avg= getAverage(userNumbers);
		System.out.println("The average was "+ avg); //sysout the results.
	}
	// Step 1 create a method that does the following.
	// static method
	//return type is int
	// prompt the user to enter x numbers
	//stores those numbers in the array
	
	static int[] getIntegers(int capacity) {
		
		System.out.println("Please enter " + capacity + " integers.");
		
		//initialize the array
		int[] numbers= new int[capacity]; 
			//create a for loop to loop the array and each time the loop executes.
			//it captures the users input and saves that input to a slot 
			//within that array.
		for (int i=0; i<numbers.length; i++) {
			//store the nextInt accepted by the scanner object and save it to index i of the array.//
			System.out.println("Enter the " + (i + 1) + " number.");
			numbers[i]=scan.nextInt();
		}
		
		//return the array
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
	
	static double getAverage(int[] userNumbers) {
		double sum = 0;
		
		for (int i = 0; i < userNumbers.length; i++) {
			//sum= sum + userNumbers[i]; //long hand
			sum += userNumbers[i]; //short hand
			}
		
	return sum / userNumbers.length;
	}
}
