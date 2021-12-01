package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {

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
	
	static double calcAverage(int[] numbersArr) {
		double average;
		
		double sum = 0;
		
		for(int i=0; i < numbersArr.length; i++) {
			sum = sum + numbersArr[i];
		}
		
		average = sum/numbersArr.length;
		
		return average;
	}
}
