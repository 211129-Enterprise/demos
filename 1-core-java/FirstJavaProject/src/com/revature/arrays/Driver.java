package com.revature.arrays;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		int capacity = 10;
		int[] numbers = new int[capacity];
		
		System.out.println(numbers);
		System.out.println(Arrays.toString(numbers));
		
		numbers[20] = 2;
		
		for(int i = 0; i < numbers.length; i++) System.out.println(numbers[i]);
		
		for(int i : numbers) System.out.println(numbers);
		
		byte[] bytes;
		bytes = new byte[16_000];
		
		char[] letters;
		String[] words = new String[5];
		String[] fruit = {"apple", "orange", "kiwi"};
		System.out.println(fruit[1]);
		Arrays.sort(fruit);
		System.out.println(Arrays.toString(fruit));
		
	}

}
