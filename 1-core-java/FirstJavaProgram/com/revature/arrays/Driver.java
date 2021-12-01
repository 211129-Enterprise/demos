package com.revature.arrays;

import java.util.Arrays;

public class Driver {
	//An array is a container object that contains elements of one type.
	//An array is static in sizing(we cannot increase or decrease.
	/*
	 * 1- declare the type of array that the array can hold
	 * 2- initialize the capacity
	 */
	public static void main(String[] args) {
		int capacity = 10;  //we just created an int array with 10 slots
		
		int[] numbers = new int [capacity];
		
		System.out.println(numbers);
		
		numbers[2]=30; //we assigned the 3rd number "30"
		//assigning every element in the array 100* the index
		for (int i=0; i<numbers.length; i++) {
			numbers[i]= (i*100);		
		}
		//enhanced for loop, this is never used as we use more lines of code.
		for (int n: numbers) {
			System.out.println(n);
		}
		System.out.println(Arrays.toString(numbers));
		//---------------------------------------------------------------------------
		byte[] bytes; //declaration
		bytes = new byte[16_000]; //initialization
		
		char [] letters;
		String[] words= new String[5];
		Object[] myObjects; 
		String[] fruit= {"apple","orange","kiwi", "fig"};
		System.out.println(fruit[1]);
		
		//create a 2d array, not part of lecture
		int[][] twoDArray =new int [2][2];
		for (int i=0; i<twoDArray.length; i++) {
			for (int j=0; j<twoDArray[i].length; j++) {
				twoDArray[i][j] = i+j;
			}
		}
		for (int[] arr: twoDArray) {
			for (int i : arr) {
				System.out.println(i+ "\t");
			}
			System.out.println("\n");
		}
		//print the word orange from the fruit array
		System.out.println();
		Arrays.sort(fruit);
		System.out.println(Arrays.toString(fruit));
	}
}
