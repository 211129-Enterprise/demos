package com.revature.linearsearch;

public class App {

	public static void main(String[] args) {

		int[] arr = { 1, 64, 221, 12, 43 };
		int x = 12;

		linearSearch(arr, x);
	}

	/**
	 * Linearly search for the value of x within the array arr O(n) Time Complexity:
	 * O(n) - Linear ( will grow in direct proportion to the size of the input data)
	 * 
	 * @return the index position of the value (x) we're searching for.
	 */
	public static int linearSearch(int[] arr, int x) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == x) {
				System.out.println(i);
				return i;
			}
			System.out.println("."); // using this to show with .'s how many 
									 // operations before finding position of x
		}
		return -1;
	}

}
