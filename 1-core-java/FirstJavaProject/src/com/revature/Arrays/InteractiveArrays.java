package com.revature.Arrays;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class InteractiveArrays {

	private static Scanner scanner = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int[] nums = getInteger(6);
	

	}
	// step 1 ; Create a method ;
	/*
	 * -static method 
	 * -return type is int[]
	 * -prompt the user to enter a x numbers
	 * -stores those numbers iun the array 
	 * 

	 *
	 */
	
	static int[] getInteger(int capacity) {
	int[] result = new int[capacity];
	for(int i=0 ; i < capacity ; i++) {
		System.out.println("Enter the  " + i + "numbvers");
		
		result[i] =  scanner.nextInt();
	}
	
		return result;
	}
	
	
	/*
	 * CHALLENGE:
	 * Create a static method that takes in an int array as a parameter.  It must return the average of all
	 * the elements within the array. (Make its return type a double).
	 * 
	 * Once you create this method, call it within the main method, and print its return, after passing through
	 * the array that was returned by the getIntegers method.
	 */
	
	static double average(int[] array) {
		double result; 
		double sum =0;
		for(int num : array) {
			sum+= num;
		}
		
		return sum/array.length;
				
	}

	public String toString(int [] input) {
		String resultString = "[";
		
		for(int num : input) {
			resultString+= num+ ", ";
		}
		
		
		return resultString + " ]";
		
	}
	
	
	
	
	
}
