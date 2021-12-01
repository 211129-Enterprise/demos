package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	/**
	 * Instantiating an array
	 * 1. declare the type of data in array
	 * 2. initialize the size of array
	 * @param args
	 */
	public static void main(String[] args) {

		int capacity = 10;
		
		int[] numbers = new int[capacity];
		
//		System.out.println(numbers);
		
		for (int i = 0; i < numbers.length; i++) 
			numbers[i] = i*100;
		
		for (int n : numbers)
			System.out.println(n);
		
		
		System.out.println(Arrays.toString(numbers));

		String[] fruit = {"apple", "orange", "kiwi"};
		
		System.out.println(fruit[1]);
		
		
		
	}

}
