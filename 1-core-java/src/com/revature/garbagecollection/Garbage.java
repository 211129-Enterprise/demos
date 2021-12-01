package com.revature.garbagecollection;

public class Garbage {
	public final static int numThatNeverChanges = 9000; //final can't ever change
	// static means global/class level shared
	// does not need an object to be called
	int someNum; //instance variable this is a proberty that can be set for each Garbage object
	
	public static void main(String[] args) {
		System.out.println("Instatinating a new Garbage object");
		Garbage gd1 = new Garbage(); // at run time its instatiated and sent to the heap
		gd1.someNum = 42;
		Garbage gd2 = new Garbage();
		gd2.someNum = 4200;
		
		System.out.println("The static variable for Garbage is " + Garbage.numThatNeverChanges);
		
		// this makes new version of the object,
		// cannot now access the previous gd1 so its removed
		
		
		gd1 = new Garbage();  // now gd1 points to a new object, so the object created on line 11 will be garbage collected because it no longer has a reference varable pointing to it
		
		gd1 = null; 
		
		// Garbage collector is non-deterministic (does its own thing)
		
		System.gc(); // encourage the collection of non-referenced objects in the heap
		
		for (;;) {
			System.out.println("....");
		}
		
	}
	
	// Every Object has a method called finalized(), which removes it from the heap
	// never called this--its in the System.gc(), we just hacked it and added the sysout's
	@Override //information to developers that we are overriding the method
	protected void finalize() { // inherited from java.lang.Object class
		System.out.println("The objects (Garbage Driver) finalized method has been called!!");
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("*********************");
		System.out.println("goodbye");
		System.exit(0); // this will end the program and 0 status as opposed to -1 which is incomplete
		
	}
	

}
