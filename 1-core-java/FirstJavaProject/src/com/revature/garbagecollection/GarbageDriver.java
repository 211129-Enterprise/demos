package com.revature.garbagecollection;

public class GarbageDriver {
	
	int someNum;//An instance variable, it changes for every Garbage Driver.
	
	final static int numThatNeverChanges = 400;//A static number does not change for any instance of the class.
	
	public static void main(String[]args) {
		
		System.out.println("Instantiating a GarbageDriver object");
		GarbageDriver gd1 = new GarbageDriver();
		gd1.someNum = 42;
		
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 39;
		gd2.someNum = 4200;//Because an instance variable is not static it may change at any time.
		
		//Because a static number does not change it may be called without an instance of an object.
		System.out.println("The static variable of the GarbageDriver is "+GarbageDriver.numThatNeverChanges);//While within the class static variables may be called on their own, outside the class they must include a reference to the class. 
		
		//Because the old gd1 object no longer has a reference variable, it is erased from the heap.
		//The java garbage collector is useful!
		gd1 = new GarbageDriver();
		
		//Now neither gd1 object has a reference so they are both dealt with by garbage collection.
		gd1 = null;
		
		//The Garbage Collector is non-deterministic. It cannot be programmed explicitly. 
		//System.gc();//System.gc encourages the collection of non-referenced objects however.
		
		for (;;) {//This for loop will continue forever, filling the heap memory until the garbage collector runs. If we comment out System.gc it will take much longer to do so.
			System.out.println("...");
		}
		
		
	}
	//Every object has a finalize method which is invoked by the GC when it is removed from the heap
	@Override
	protected void finalize() {
		System.out.println("Finalize method has been called.");
		
		System.exit(0);//This exits the program while saying nothing went wrong.		
	}
}
