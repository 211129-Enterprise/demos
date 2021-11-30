package com.revature.grabagecolection;

public class GrabageDriver {
	
	int someNum; // field .
	
	
	// it's an instance variable . so it's a proprety that belong to the class;
	
	final static int finalNum = 400;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("intialiating a garbage Driver Object");
		
		GrabageDriver gd1 = new GrabageDriver(); // new object ent to the heap;
		gd1.someNum = 42;
		
		GrabageDriver gd2 = new GrabageDriver();
		gd1.someNum = 40;
		
		
		System.out.println("the static variable for the garbage " + GrabageDriver.finalNum);
		
		
		gd1 = new GrabageDriver(); // 
		
		/*
		 * Object created on line 18 is now garbage collected because now it dosnt 
		 * have a refrence in the stack . 
		 * 
		 * 
		 */
		
		//  the Garbage colector is non-determistic 
		// we can make a suggestion  but we cannot force it
		
		System.gc(); // will encourage the collection of non-reffrence obj in the the heap
		
		//
		//@Override
		// finilyze ;
		
		
		
		
		
		
		// 
		
	}

}
