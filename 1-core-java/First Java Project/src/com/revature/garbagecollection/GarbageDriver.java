package com.revature.garbagecollection;

public class GarbageDriver {
	
	// The static keyword means that this value is shared on a global or class level.
	final static int numThatNeverChanges = 9000;
	
	int someNum; // instance variable - property which can be set for each GarbageDriver object (not static)

	public static void main(String[] args) {
		
		System.out.println("Instantiating a garbage driver object.");
		
		GarbageDriver gd1 = new GarbageDriver();
		gd1.someNum = 42;
		
		
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 4200;
		
		
		System.out.println("The static variable for the Garbage Driver is " + GarbageDriver.numThatNeverChanges);
		
		gd1 = new GarbageDriver();
		
		gd1 = null;
		
		System.gc();
		
		
		
		while (true) {
			System.out.println("...");
		}
	}
	
	// Every object has a method called finalize() which is invoked by the GC when it's removed from the heap
	@Override
	protected void finalize() {
		System.out.println("The object's (Gargabe Driver) finalize method has been called!");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("**************************************");
		System.out.println("Bye bye!");
		
		System.exit(0); // this will end the program, 0 status means that nothing bad happened - a normal exit
	}

}
