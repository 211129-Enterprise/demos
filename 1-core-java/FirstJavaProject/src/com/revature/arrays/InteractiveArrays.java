package com.revature.arrays;

import java.util.Scanner;

public class InteractiveArrays {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] array = getIntegers(10);
		double average = getAverage(array);
		printArray(array);
		
	}
	
	static int[] getIntegers(int capacity) {
		int[] numbers = new int[capacity];
		for(int i = 0; i < numbers.length; i++) numbers[i] = scanner.nextInt();
		return numbers;
	}
	
	static double getAverage(int[] array) {
		double sum = 0.0;
		for(int i : array) sum += (double) i;
		sum /= array.length;
		return sum;
	}
	
	static void printArray(int[] array) {
		for(int i : array) System.out.println(i + " ");
	}
	
}
