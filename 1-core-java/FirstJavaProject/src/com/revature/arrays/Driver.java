package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	
	public static void main(String[] args) {
		int capacity = 10;
		
		int[] numbers = new int[capacity];
		
		System.out.println(numbers);
		
		System.out.println(Arrays.toString(numbers));
		
		numbers[2] = 30; // we are assigning a value to an element at an index
		
		for (int i=0; i<numbers.length; i++) {
			// O(n) number of operations increases linearly with the ammount of data
			// that's passed through. ( linear time complexity ) 
			numbers[i] = i * 100;
			
		}
		
		for(int n: numbers) {
			System.out.println(n);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		
		byte[] bytes; // declaring array, no object has been created in the heap
		bytes = new byte[16_000]; // initialization
		
		char[] letters;
		String[] words = new String{5];
		
		Object[] myObjects;
		
		String[fruit] = {"apple", "orange", "kiwi"}
		}
	}
}
