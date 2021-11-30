package com.revature.garbagecollection;

public class GarbageDriver {

	// The static keyword means that this value is shared on a global or class level.
	final static int numThatNeverChanges = 9000;
	
	int someNum; // this is an instance variable. It is a property that can be set for each object of Garbage Driver
	String name;
	
	public static void main(String[] args) {
		
		System.out.println("Instantiating a Garbage Drvier Object");
		
		GarbageDriver gd1 = new GarbageDriver();
		gd1.someNum = 42;
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 4200;
		gd2.someNum = 1;
		
		
		System.out.println("The static variable for the GarbageDriver is: " + GarbageDriver.numThatNeverChanges);
		
		// this is impossible
		// GarbageDriver.numThatNeverChanges = 1;
		
		
		gd1 = new GarbageDriver(); // now gd1 points to a new object, so the object instantiated on line 15  will be garbage collected(cleared from memory?);
		
		gd1 = null; // now both objects are 
		
		// the Garbage Collector is non-deterministic
		
		for(;;) {
			System.out.println("...");
			System.gc();
		}
//		System.gc(); // will encourage collection of non-referenced objects in the heap.

	}
	
	
	// Every object has a method called finalize() garbage collector uses this method to remove it from the heap
	
	@Override
	protected void finalize() {
		
		System.out.println("The object's (Garbage Disposal) finalize method has been called!!! ");
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("Goodbye!");
		
		System.exit(0);// this will end the program, 0 status means nothing bad happened - a normal exit
		
	}

}
