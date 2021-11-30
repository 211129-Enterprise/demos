package com.revature.garbagecollection;

public class GarbageDriver {
	
	final static int numThatNeverChanges = 9000;
	int someNum;

	public static void main(String[] args) {
		
		System.out.println("Instantiating a Garbage Driver Object");
		GarbageDriver garbageDriver = new GarbageDriver();
		garbageDriver.someNum = 43;
		GarbageDriver garbageDriver2 = new GarbageDriver();
		garbageDriver2.someNum = 4200;
		
		garbageDriver = null;
		garbageDriver2 = null;
		System.gc();
	}
	
	@Override
	protected void finalize() {
		System.out.println("Hey Im deleted");
	}

}
