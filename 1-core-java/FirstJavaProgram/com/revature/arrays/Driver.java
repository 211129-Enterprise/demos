package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	
	/**
	 * An array is a container object that contains elements of ONE type
	 * It's an object that's stored in the heap
	 * 
	 * An array is STATIC in sizing (we can't increase or decrease)
	 * 
	 * - (1) declare the type that the array holds
	 * - (2) Initialize the capacity
	 */
	public static void main(String[] args) {
		int capacity = 10;
		
		//We just created an int array with 10 slots
		int[] numbers = new int[capacity];

//		System.out.println(numbers); //Prints "Array that Holds Integers" w/ hash code
		
		System.out.println(Arrays.toString(numbers)); //Prints out the contents
		//Default for integer array is 0
		
		numbers[2] = 30; //Assigning a value to an element at an index
		numbers[0] = 10; //<----Constant time complexity
		
		//I want to assign every element within the array to the value of 100 * its index
		for(int i = 0; i < numbers.length; i++) {
			
			// O(n)
			// Linear time complexity 
			// The # of operations increases linearly with the amount of data that's passed through the for loop
			numbers[i] = (i * 100);
		}
		
		// Enhanced forloop - we don't have access to the index
		for(int n : numbers) {
			System.out.println(n);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		
		//Declaring the array, not initializing it so no object has been created in the heap
		byte[] bytes;
		bytes = new byte[16_000]; //Initialization so now it has been created in the heap
		
		char[] letters;
		String[] words = new String[5];
		
		Object[] myObjects; //Super class
		
		String[] fruitz = {"Apple", "Orange", "Kiwi"};
		
		//Print the word Orange from the fruit array
		System.out.println( fruitz[1] );
		
		//Two dimensional array example
		int[][] twoDimensionalArr = new int[2][2];
		
		for(int i = 0; i < twoDimensionalArr.length; i++) {
			
			for(int j = 0; j < twoDimensionalArr[i].length; j++) {
				
				twoDimensionalArr[i][j] = i + j;
			}
		}
		
		//Print out the 2-D array
		for(int[] arr : twoDimensionalArr) {
			for(int i : arr) {
				System.out.println(i + "\t");
			}
			System.out.println("\n");
		}
		
		String[] fruit = {"Fig", "Orange", "Kiwi", "Apple"};
		System.out.println(Arrays.toString(fruit)); //Prints out in order it was initialized in
				Arrays.sort(fruit); //Strings are sorted by lexographic (ascending) order by default
		System.out.println(Arrays.toString(fruit)); //Prints out as in ascending order
		
	}

}
