package com.revature.searching;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Animal;

public class AlgorithmDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1, 4, 23, 52, 64, 65, 66, 89};
		
		int target = 65;
		
		linearSearch(arr, target);
		
		System.out.println("=================");
		
		binarySearch(arr, target);
		
		
	}
	
	// logarithmic time O(log n)
	private static int binarySearch(int[] arr, int target) {
		int min = 0;
		int max = arr.length - 1;
		
		while(min <= max) {
			
			System.out.println("searching ..........");
			
			int mid = (min + max) / 2;
			
			if (target < arr[mid]) {
				max = mid - 1;
			} else if (target > arr[mid]) {
				min = mid + 1;
			} else {
				System.out.println("found" + target + " at index " + mid);
				return mid;
			}
		}
		return -1;
	}
	// linear search - O(n) linear time complexity
	private static int linearSearch(int[] arr, int target) {
		for (int i = 0 ; i < arr.length; i++) {
			System.out.println("searching .......");
			if (arr[i] == target) {
				System.out.println("found" + target + "at index" + i);
				return i;
			}
			
		}
		return -1;
	}

}
