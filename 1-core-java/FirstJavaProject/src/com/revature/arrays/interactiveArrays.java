package com.revature.arrays;

import java.util.Scanner;

public class interactiveArrays {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] userNumbers =  getIntegers(5);
		
		double average = getAverage(userNumbers);
		
		System.out.println("the average is" + average);
		
		

	}
	/*
	// Step 1. Create a method that does the following
	- static method
	- return type is int[]
	- prompt the user to enter x numbers
	- stores those numbers in the array
	*/
	private static int[] getIntegers(int capacity) {
		
		
		System.out.println("Please Enter" + capacity + " integers");
		
		int[] numbers = new int[capacity];
		
		
		for (int i=0; i<numbers.length; i++) {
			System.out.println("Enter the " + (i + 1) + " number");
			numbers[i] = scan.nextInt();
		}
				
	    
		
		return numbers;
	}
	
	private static double getAverage(int[] arr) {
		int sum = 0;
		double avg = 0;
		for(int n: arr) {
			sum += n;
		}
		avg = sum / arr.length;
		
		return avg;
		
	}

	private static void printArray(int[] arr) {
		System.out.println(arr.toString());
	}
	
}
