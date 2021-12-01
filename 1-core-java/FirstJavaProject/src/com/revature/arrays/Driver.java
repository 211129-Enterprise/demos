package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		/**
		 * An array is a container object that contains elements of one type
		 * 
		 * An array is static in sizing -> we cannot increase or decreasse capacity
		 * 
		 * steps
		 * 1. declare the data type it will hold
		 * 2. initialize the capacity
		 */
		
		int capacity = 10;
		
		int[] numbers = new int[capacity];
		// we just created with 10 slots basically
		
//		System.out.println(numbers);
		
		numbers[2] = 30; // we are assignig a value to a slot with index 2 
		numbers[0] = 10; // tedious way
		
		// 100 times of index
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i * 100;
			//O(n) -> amount of operations is linear to amount of input / data passed through
		}
		
		
		// enhanced for loop - we don't have access to index
		
		for (int n : numbers) {
			System.out.println(n);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		// byte array 
		
		byte[]  bytes; // just declaring the array, not initializing
		
		bytes = new byte[16_000];
		
		char[] letters;
		
		String[] words = new String[5];
		
		int[][] twoDArray = new int[2][2];
		
		String[] fruits = {"apple", "fig", "orange", "kiwi"};
		
		System.out.println(Arrays.toString(fruits));
		
		Arrays.sort(fruits); //strings are sorted ascending order
		
		System.out.println(Arrays.toString(fruits));
		
		
	}

}
