package com.revature.garbadgecollection;

public class GarbadgeDriver {
	// static variables are available at a class/global level , no need to create an object 
	final static int numThatNeverChanges = 9000;
	int someNum; // this is an instance variable. A property that can be set for each gd object

	public static void main(String[] args) {
		System.out.println("Instantiating a Garbadge Driver Object");
		GarbadgeDriver GD1 = new GarbadgeDriver(); // runtime instantiated and sent to the heap	
		// floating around the heap like a cut up balloon after gd1 pointing to another heap location
		// then it will be garbadge collected.
		GD1.someNum = 42;
		
		GarbadgeDriver GD2 = new GarbadgeDriver();	
		GD2.someNum = 4200;
		
		GD1 = new GarbadgeDriver();
		
		// we can never force it. we can only suggest
		//e collector is non deterministic 
		System.gc();
	}

}
