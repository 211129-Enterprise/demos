package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
//		String[] A = StdIn.readAllStrings(); 
		
	}

	protected static int maxSum(int[] A){
        int currentSum = A[0];
        int maxSum = A[0];
        for(int i=1;i<A.length;i++){
            if(currentSum < 0)
                currentSum = 0;
            currentSum = A[i] + currentSum;
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
	
	protected static int maxArray(int[] arr) {
		int noncircSum = maxSum(arr);
		int totalSum = 0;
		for(int i=0;i<arr.length;i++){
			totalSum += arr[i];
			arr[i] = -arr[i];
		}	
		int circSum = totalSum + maxSum(arr);
		if(circSum == 0) {
			return noncircSum;
		}
		return Math.max(circSum,noncircSum);
		
	}
	
	
	
}