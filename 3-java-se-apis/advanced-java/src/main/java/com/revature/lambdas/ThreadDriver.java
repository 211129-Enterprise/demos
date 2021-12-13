package com.revature.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ThreadDriver {

	public static void main(String[] args) { /* O N E  T H R E A D */
		
//		List<Employee> employees = new ArrayList<>(); // NOT thread safe as threads are sharing from heap and this is not synchronized
		List<Employee> employees = new Vector<>();
		
		// Here we will instantiate a thread that has the behavior of MyTask
		Thread t1 = new Thread( new MyTask() );  /* A N O T H E R  T H R E A D */
			
		t1.start();

		
		
		
		// How would we do the same thing as above that uses MyTask and Thread
		//	Create a thread called with ref variable t2,
		//	and its run method says "Printing from the anonymous class"
		Thread t2 = new Thread(new Runnable() { /* A N O T H E R  T H R E A D */

			@Override
			public void run() {
				System.out.println("Printing from the Anonymous Runnable Object");
				
			}
			
		});
		t2.start();

		
		
		
		// How would we do the same thing as above but with a lambda expression.
		Thread t3 = new Thread( () -> System.out.println("Running from the lambda implementation") ); /* A N O T H E R  T H R E A D */ 
		t3.start(); // "Running from the lambda expression implementation!"
		

	}
}


//	// Create my own functional interface!
//	// ... can create here but just can't be public
//	interface UpperConcat{
//		
//		public String upperAndConcat(String s1, String s2);
//		
//	}


class MyTask implements Runnable { // Functional interface implemented by

	@Override
	public void run() {

		System.out.println("Printing from the Runnable object, MyTask");
		
	}
	
}