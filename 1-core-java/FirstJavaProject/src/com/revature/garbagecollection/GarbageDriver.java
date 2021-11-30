/**
 * 
 */
package com.revature.garbagecollection;

/**
 * @author robot
 *
 */
public class GarbageDriver {

    // the static keyword is shared on a global/class level
    final static int CONSTANT = 9000;

    int someNum; // instance variable - a property that can be set for each GD object

	public static void main(String[] args) {
	    System.out.println("Instantiating a Garbage Driver Object");
	    
	    GarbageDriver gd1 = new GarbageDriver();
	    gd1.someNum = 42;
	
	    
	    System.out.println("Instantiating another Garbage Driver Object");
	    GarbageDriver gd2 = new GarbageDriver();
	    gd2.someNum = 4200;
	    
	    System.out.println("The static variable for the Garbage Driver is " + GarbageDriver.CONSTANT);
	    
	    gd1 = new GarbageDriver(); // now gd1 points to a new object
	    
	    gd1 = null; // now both
	    
	    // The Garbage Collector is non-deterministic
	    
	    System.gc(); // will encourage the collection of non-referenced objects in the heap
	}

    // Every Object has a method called finalize() which is invoked by the GC when it is removed from the heap
    @Override
    protected void finalize() {
        
    	System.out.println("The object's (GarbageDriver) finalize method has been called!!!");
    	
    	System.out.println("=============================");
    	System.out.println("=============================");
    	System.out.println("=============================");
    	System.out.println("=============================");
    	System.out.println("=============================");
    	System.out.println("=============================");
    	System.out.println("=============================");
    	System.out.println("=============================");
    	System.out.println("=============================");
    	
    	System.out.println("goodbye!");
    }   

}
