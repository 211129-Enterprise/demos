package com.revature.searching;

public class AlgorithDriver {

	static public int num =0;
	 public static int x = 1;
	  public int y = 2;
	
	static {
		System.out.println("hello world from the static block 111111");
		
		num =12;
		System.out.println(num++);
		
		num();
		
		int  numInStatic =10002838 ;
		
	}
//	
	static void num() {
		System.out.println( 100) ;
	}
	
	
	public static void main(String[] args) {
		
		 int[] arr = {1,2,65 , 98 , 89};
		
		int target = 60 ;
//		linerSerach(arr, 9);
//		System.out.println(binarySearch(arr, 9));
		
		System.out.println("in maine method *************888888888");
		
		System.out.println("before instansition ==========");
		
		TryStaticBlock n1 = new TryStaticBlock();
		
		TryStaticBlock n2 = new TryStaticBlock();
		TryStaticBlock n3 = new TryStaticBlock();
		TryStaticBlock n4 = new TryStaticBlock();
		
		System.out.println("after instansition ==========");
		
		
		System.out.println(TryStaticBlock.name + "   here   ;;;;;;;;");
		
		
		System.out.println("after main &&&&&&&&&&");
		AlgorithDriver.doStuff();
//		can't see variale in static block
//		System.out.println( numInStatic + " here we go babies ");
		
		
		
	}
	


	  public static void doStuff() {
	    System.out.println(x);
	  }

	  public void doMoreStuff() {
	    System.out.println(x);
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
