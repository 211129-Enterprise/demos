package com.revature.garbagecollection;

public class GarbageDriver {
	
<<<<<<< HEAD
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
=======
	// The static keyword means that this value is shared on a global or class level
	// it's final 
	public final static int numThatNeverChanges = 9000; 
	
	int someNum; // this is an instance varibale.  So it's a property that can be set for each GD object
	

	public static void main(String[] args) {
		
		System.out.println("Instantiating a Garbage Driver Object");
		
		GarbageDriver gd1 = new GarbageDriver(); // new object sent to the heap!
		gd1.someNum = 42;
		
		System.out.println("Instantiating another Garbage Driver Object");
		GarbageDriver gd2 = new GarbageDriver();
		gd2.someNum = 4200;
		gd2.someNum = 1;
		
		
		System.out.println("gd2's someNum property is " + gd2.someNum);
		
		System.out.println("The static variable for the Garbage Driver is " + GarbageDriver.numThatNeverChanges);
		
		// this is impossible
//		GarbageDriver.numThatNeverChanges = 200;
		
		gd1 = new GarbageDriver(); // now gd1 points to a new object, so the object instantiated on line 15 will be garbage collected.
		
		gd1 = null; // now both 
		
		// The Garbag
	
	
	// Garbage Collector is non-deterministic 
		
		System.gc(); // will encourage the collection of non-referenced objects in the heap
		
		for (;;) {
			System.out.println("...");
		}
		
	}
	
	// Every Object has a method called finalize() which is invoked by the GC when it's removed from the heap

	@Override
	 protected void finalize() { // that's inherited from the java.lang.Object class
		 
		 System.out.println("The object's (Garbage Driver) finalize method has been called!!!!  ");
		 
		 System.out.println("***************************");
		 System.out.println("***************************");
		 System.out.println("***************************");
		 System.out.println("***************************");
		 System.out.println("***************************");
		 System.out.println("***************************");
		 System.out.println("***************************");
		 System.out.println("***************************");
		 System.out.println("***************************");
		 
		 System.out.println("goodbye!");
		 
		 System.exit(0); // this will end the program and 0 status means that nothing bad happend - a normal exit 
		 
	 }

>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
}
