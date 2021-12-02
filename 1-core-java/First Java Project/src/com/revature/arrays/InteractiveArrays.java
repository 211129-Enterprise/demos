package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	// declare a scanner as a static member of this class
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int[] numbers = getIntegers(5);
		
		double mean = getMean(numbers);
		
		System.out.println(mean);
		
		printArray(numbers);
		
		

	}

	/**
	 * Step 1. Create a method:
	 * - static method
	 * - return type is int[]
	 * - prompt user to enter x numbers
	 * - stores those numbers in the array
	 * 
	 */
	
	static int[] getIntegers(int capacity) {
		
		System.out.println("Please enter " + capacity + " integers.");
		
		int[] numbers = new int[capacity];
		
		for (int i = 0; i < capacity; i++) {
			numbers[i] = scan.nextInt();
		}
		
		return numbers;
	}
	
	static double getMean(int[] numbers) {
		
		double sum = 0;
		double mean = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		
		mean = sum / numbers.length;
		
		
		return mean;
	}
	
	static void printArray(int[] numbers) {
		System.out.print('[');
		for (int i = 0; i < numbers.length; i++) {
			if (i == numbers.length - 1)
				System.out.print(numbers[i]);
			else
				System.out.print(numbers[i] + ", ");
		}
		System.out.println(']');
	}
}
