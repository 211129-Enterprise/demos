package com.revature.Arrays;

import java.util.Arrays;

public class Driver {
	
	/*An Array is a container object 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		int capacity = 10;
		
		int[] numbers = new int[10];
		
		System.out.println(numbers);
		
		System.out.println(Arrays.toString(numbers));
		
		for(int i=0 ; i< numbers.length; i++) {
			// O(n) linear time ;
			
			numbers[i] = i*100;
		}
		
		for(int n: numbers) {
			System.out.println(n);
		}
		
		String[] fruiStrings = {"orange", "apple", "kiwi", "fig"};
		
		Arrays.sort(fruiStrings);
		
		System.out.println(Arrays.toString(fruiStrings));
		
	}
}
