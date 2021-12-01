package com.revature.arrays;

import java.util.Arrays;

public class Driver {
	
	/**
	 * An array is a container object that contains elements of ONE type.
	 * 
	 * An array is STATIC in sizing (we can't increase or decrease)
	 * 
	 * - (1) declare the type that the array can hold
	 * - (2) initialize the capacity
	 */
	
	public static void main(String[] args) {
		
		int capacity = 10;
		
		// we just created an int array with 10 slots 
		int[] numbers = new int[capacity];
		
		// we need to run the toString static method
//		System.out.println(numbers);
		
		numbers[2] = 30; // we are assigning a value to an element at an index
		numbers[0] = 10;
		
		// I want to assign every element within  the array to the value of 100 * it's index
		
		for (int i=0; i<numbers.length; i++) {
			
			// O(n) (# of operations increases linearly with the amount of data that's passed through thte for loop
			numbers[i] = (i * 100);
			
		}
		
		// enhanced for loop - we don't have access to the index
		for (int n : numbers) {
			System.out.println(n);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		// [_0_ _1__ _2_ _3_ __ __ __ __] zero-indexed
		
		byte[] bytes; // declaring the array, not initializing
		bytes = new byte[16_000]; // intialization
		
		char[] letters;
		String[] words = new String[5];
		
		Object[] myObjects;
		
		// how to intialize
		int[][] twoDArr = new int[2][2]; 
		
		for (int i=0; i< twoDArr.length; i++) {
			
			for (int j=0; j<twoDArr[i].length; j++) {
				
				twoDArr[i][j] = i + j;
			}
		}
		
		// print out
		for (int[] arr : twoDArr) {
			for (int i : arr) {
				
				System.out.println(i + "\t");
			}
			System.out.println("\n");
		}
		
		String[] fruit = {"fig", "orange", "kiwi", "apple"};
		
		// print the word orange from the fruit array 
		System.out.println(fruit[1]);
		
		System.out.println(Arrays.toString(fruit)); // strl + click open declaration
		Arrays.sort(fruit); // strings are sorted by ascending order
		System.out.println(Arrays.toString(fruit));
		
		
		
	}

}
