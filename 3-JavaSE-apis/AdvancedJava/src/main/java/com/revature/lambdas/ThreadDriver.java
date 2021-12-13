package com.revature.lambdas;

import java.util.List;
import java.util.Vector;

public class ThreadDriver {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new Vector<Employee>();
		
		
		// here we will instantiate a thread that has the behavior of MyTask
		
		Thread t1 = new Thread(new MyTask());
		
		t1.start();
		
		// How would we do the same thing with an Anonymous class?
		// Create a thread called with ref variable t2, and its run method says "Printing from anonymous Runnable object"
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Printing from the Anonymous Runnable object!");
			}
		});
		
		t2.start();
		
		// how would you provide a method implementation for the run() method via a lambda expression
		Thread t3 = new Thread(() -> System.out.println("Printing from the Lambda Implementation"));
		
		t3.start();
	}
	
}


class MyTask implements Runnable { // functional interface implemented by

	@Override
	public void run() {
		
		System.out.println("Printing from the Runnable object, MyTask");
	
	}
	
}

