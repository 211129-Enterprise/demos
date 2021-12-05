package com.revature;

public class AlgorithmDriver {
	public static void main(String[] args) {
		int[] arr = {1,4,23,52,64,65,66,89};
		int target = 65;
		linearSearch(arr, target);
		binarySearch(arr, target);
	}
	
	private static int linearSearch(int[] arr, int target) {
		int numOperations = 0;
		for(int i = 0; i < arr.length; i++) {
			numOperations++;
			if(arr[i] == target) {
				System.out.println(numOperations);
				return i;
			}
		}
		
		return -1;
	}
	
	private static int binarySearch(int[] arr, int target) {
		int numOperations = 0;
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			numOperations++;
			int mid = (right + left) / 2;
			if(arr[mid] == target) {
				System.out.println(numOperations);
				return mid; 
			}
			else if(arr[mid] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
