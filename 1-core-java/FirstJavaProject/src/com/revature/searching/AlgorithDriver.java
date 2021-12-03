package com.revature.searching;

public class AlgorithDriver {


	
	public static void main(String[] args) {
		
		 int[] arr = {1,2,65 , 98 , 89};
		
		int target = 60 ;
//		linerSerach(arr, 9);
		System.out.println(binarySearch(arr, 9));
	}
	
	private static int linerSerach(int[] arr , int target) {
		
		for(int i  =0 ; i < arr.length ; i++) {
			System.out.println("searching ");
			if(arr[i] == target) {
				System.out.println("found target");
				return i ;
			}
		}
		
		return -1;
	}
	
	private static int  binarySearch(int[] arr , int target) {
		
		int min =0;
		int max = arr.length-1;
		
		
		
		while(min <= max) {
			System.out.println("searching ....");
			int mid = (min+ max)/2;
			
			if(target < arr[mid]) {
				max = mid-1 ;
			}else if(target > arr[mid]) {
				min = mid+1;
			}else {
				return mid ;
			}
			
		}
	
		
		
		return -1;
	}
	
	
}
