package com.revature.garbagecollection;

public class GarbageDriver {
	
	//The static keyword means that this value is shared on a global / class level
	public final static int numThatNeverChanges = 9000; //since it's public it can be called outside this class
	
	int someNum; //this is an instance variable. So it's a property that can be set for each GD object

	public static void main(String[] args) {
		
		System.out.println( "Instantiating a Garbage Driver Object" );
		
		GarbageDriver gd1 = new GarbageDriver(); //new object sent to the heap!
		gd1.someNum = 42;
		
		System.out.println( "Instantiating another Garbage Driver Object" );
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum =  4200;
		gd2.someNum = 1; //Can be re-assigned but numThatNeverChanges cannot be changed
		
		System.out.println( "gd2's someNum property is " + gd2.someNum );
		
		System.out.println( "The static variable for the Garbage Driver is " + GarbageDriver.numThatNeverChanges );
		
//		//this is impossible
//		GarbageDriver.numThatNeverChanges = 200;
		
		gd1 = new GarbageDriver(); //now gd1 points to a new object, so the object created on line 15 will be garbage collected.
		
		gd1 = null; //now both objects are garbage collected. Also, null is default value
		
		//The garbage collector is non-deterministic.
		System.gc(); //will encourage the collection of non-referenced objects in the heap
		//If not called then the Garbage collection may never happen because the program is so small and doesn't require much memory
	}
	
	
	//Every object has a method called finalize() which is invoked by the GC when its removed from the heap
	@Override
	protected void finalize() { //inherited from the java.lang.Object class
		System.out.println( "***************************************************************" );
		System.out.println( "The object's (Garbage Driver) final method has been called!!!! " );
		System.out.println( "***************************************************************" );
		System.out.println( "goodbye!" );
		
		System.exit( 0 ); //this will end the program and 0 status means that nothing bad happened - a normal exit
	}

}
