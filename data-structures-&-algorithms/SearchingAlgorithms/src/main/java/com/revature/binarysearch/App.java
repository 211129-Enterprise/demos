package com.revature.binarysearch;

public class App {

	// consider that int[] arr is SORTED
	public static int binarySearch(int[] arr, int x) {
		int min = 0;
		int max = arr.length - 1;

		while (min <= max) {
			
			int mid = (min + max) / 2;
			
			if (x < arr[mid]) { // if the target value is less than
				max = mid - 1; // the midpoint, we discard the RHS
			} else if (x > arr[mid]) {
				min = mid + 1; // otherwise we discard the LHS
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * - RHS = right hand side
	 * - LHS = left hand side
	 */
}

