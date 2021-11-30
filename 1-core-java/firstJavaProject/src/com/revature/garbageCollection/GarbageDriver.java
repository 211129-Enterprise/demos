package com.revature.garbageCollection;

/**
 * @author kphu
 *
 */
public class GarbageDriver {
	
	// The static keyword means that this value is shared on a global or class level
	// it's final
	final static int numThatNeverChanges = 9000;
	
	int someNum; // this is an instance variable. So it's a property that can be set for each GD object
	
	
	public static void main(String[] args) {
		
		System.out.println("Instantiating a Garbage Driver Object");
		
		GarbageDriver gd1 = new GarbageDriver(); // new object sent to the heap!
		gd1.someNum = 42;
		
		System.out.println("Instantiating another Garbage Driver Object");
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 4200;
		gd2.someNum = 1;
		
		
		System.out.println("The static variable for the Garbage Driver is " + GarbageDriver.numThatNeverChanges);
		
		// this is impossible
//		GarbageDriver.numThatNeverChanges = 200;
		
		gd1 = new GarbageDriver(); // now gd1 points to a new object, so the object instantiated on line 15 will garbage collected.
		
		gd1 = null; // now both objects will be garbage collected.
		
		// The Garbage Collector is non-deterministic 
		
		System.gc(); // will encourage the collection of non-referenced objects in the heap
		
		for (;;) {
			System.out.println("...");
		}
		
	}
	
	// Every Object has a method called finalize() which is invoked by the GC when it's removed from the heap
	
	@Override
	protected void finalize() { // that's inherited from the java.lang.Object class
		
		System.out.println("THe object's (Garbage Driver) finalize method has been called!!!!  ");
		
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		System.out.println("*******************************************************************");
		
		System.out.println("goodbye!");
		
		System.exit(0); // this will end hte program and 0 status means that nothing happened - a normal exit

	}
	
	
	
	
	
	

}
