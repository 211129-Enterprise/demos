package com.revature.garbagecollection;

public class GarbageDriver {

	final static int numThatNeverChanges = 9000; 
	
	int someNum;// this is an instance variable. So its property that can be set for each GD object
	
	public static void main(String[] args) {
	
		System.out.println("Instantiaing a Garbase Driver Object");
		
		GarbageDriver gd1 = new GarbageDriver(); // new object sent to the heap!
		gd1.someNum = 42;
		
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 4200;
		gd2.someNum = 1;
		
		System.out.println("The static variable for the Garbage Driver is " + GarbageDriver.numThatNeverChanges);
		
		// this is impossible
		// GarbageDriver.numThatNeverChanges = 200;
		
		gd1 = new GarbageDriver(); // now gd1 points to a new object, 
							  //so the object instantiated on line 15 will be garbaged collected
		
		gd1 = null; // now both
		
		
		
		// The Garbage Collector is non-deterministic
		
		System.gc(); // will encourage the collection of non-referenced objects in the heap
		
		
 }
	
	// every object has a method called finalize() which is invoked by the GC when its removed from the heap
	
	@override
	protected void finalize() {
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
	}
}
