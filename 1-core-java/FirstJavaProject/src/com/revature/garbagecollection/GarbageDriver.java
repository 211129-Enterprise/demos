package com.revature.garbagecollection;

public class GarbageDriver {
	
	final static int numThatNeverChanges = 9000;
	
	int someNum; //  instance variable. So it's a properly that can be set for each GD object

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Instantiating a Garbage Driver Object");
		
		GarbageDriver gd1 = new GarbageDriver(); // new object sent to the heap
		gd1.someNum = 42;
		
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 4200;
		gd2.someNum = 1;
		
		System.out.println("The static variable for the Garbage Driver is " + GarbageDriver.numThatNeverChanges);
		
        gd1 = new GarbageDriver(); // new gd1 points to a new object, so the object instantiated on line 15 will be garbage collected
        
        gd1 = null; // new both
        
        // The Garbage Collector is non-deterministic. It cannot be forced.
        
//        System.gc();
        
        for (;;) {
        	System.out.println("...");
        }
	}

	
	// Every Object has a method called finalize() which is invoked by the GC when it's removed from the heap
	@Override
	protected void finalize() {
		System.out.println("The object's (Garbage Driver) finalize method has been called!!!   ");
		
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		
		System.out.println("goodbye!");
		
		System.exit(0); // this will end the program and 0 status means that nothing had happened a normal exit
		
		
	}
}
