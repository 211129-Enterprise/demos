package com.revature.arrays;

//import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {

	// declare scanner as a static member
	private static Scanner scan = new Scanner(System.in); // ctrl + Shift + O to import fast
	
	public static void main(String[] args) {
		
		int[] userNumbers = getIntegers(5);
		
		printArray(userNumbers);
		System.out.println("");
		
		System.out.println("Average of numbers entered = " + averageInput(userNumbers));
		
	}
	
	/**
	 *  Step 1: Create method to do the following
	 *  
	 *  - static method
	 *  - returns int[]
	 *  - prompt user to enter x numbers
	 *  stores those numbers in the array
	 *  
	 *
	 *	challange: create static method that takes an int array as a parameter. return the average as a double
	 *	then print the result from the main method
	 *
	 *	bonus: create a method to print array, so we don't have to keep calling Arrays.toString
	 *   
	 */
	
	
	static int[] getIntegers(int capacity) {
		
		System.out.println("Please enter " + capacity + " Integers");
		
		// initialize array
		int[] numbers = new int[capacity];
		
		// create loop to go through the array, and each time the loop executes it captures the input and saves it into the array
		
	
		for (int i = 0; i< numbers.length; i++) {
			System.out.println("please enter number for slot " + (i+1) );
			numbers[i] = scan.nextInt();
			System.out.println(numbers[i] +" was added to slot " + (i+1));
			
		}
		
		
		
		
		return numbers;
	}
	
	private static double averageInput(int[] input) {
		double avg;
		double total = 0;
		double ammount = input.length;
		
		for (int i = 0; i< ammount; i++) {
			total += input[i];
		}
		avg = (total / ammount);
		
		return avg;
	}
	
	private static void printArray(int[] input) {
		
		for(int n : input) {
			System.out.print(n+" ");
		}
//		System.out.println(Arrays.toString(input));
		
	}
}
