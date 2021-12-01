package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	/**
	 *  Array - an array is a container object that contains elements of one type
	 *  
	 *  An array is static in size (cannot increase or decrease space inside
	 *  
	 *  - 1 declare type
	 *  - 2 initialize the capacity
	 */
	
	public static void main(String[] args) {
	
		int capacity = 10;
		
		// Create an array that holds int with 10 spaces inside
		int[] numbers = new int[capacity];
		
		// lets's add things to the array
		numbers[2] = 30;
		numbers[0] = 10;
		
		// I want to assign every element within the array to the value of 100* index
		
		for (int i = 0; i < numbers.length; i++) {
			// O(n) # of operations increases linearly with ammount of data that's passed into the loop
			numbers[i] = (i*100);
		}
		
		// enhanced for loop - we don't have access to the index - efficiency is the same as normal for loop
		for(int n : numbers) {
			System.out.println(n);
		}
		
		
		System.out.println(Arrays.toString(numbers));
		
		// Arrays are 0 indexed, 0, 1, 2... etc Zero-Indexed
		
		byte[] bytes; // declaring  array, not initializing
		bytes = new byte[16_000]; // initilizing
		
		char[] letters;
		String[] words = new String[5];
		
		Object[] myObjects;

		
		int[][] twoDArr = new int[2][2];
		
		for (int i = 0; i< twoDArr.length; i++) {
			for (int j = 0; j< twoDArr[i].length; j++) {
				twoDArr[i][j] = i+j;
			}
		}
		for (int[] arr : twoDArr){
			for(int i : arr) {
				System.out.println(i + "\t");
			}
			System.out.println("\n");
		}
		
		String[] fruit = {"fig", "orange", "kiwi", "apple"};
		
		System.out.println(fruit[1] +"\n");
		
		System.out.println(Arrays.toString(fruit));
		Arrays.sort(fruit); // Strings are sorted by lexographic order
		System.out.println(Arrays.toString(fruit));

		
		
		
	}

}


