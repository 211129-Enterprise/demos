package com.revature.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ThreadDriver {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>(); // not thread safe.
		List<Employee> employeesV = new Vector<>(); // thread safe. all of its methods are synchronized.
		
		Thread t1 = new Thread(new MyTask()); // now inherits whatever functionality defined in class.
		//if not passed anothing, thread won't do anything without passing anything.
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Printing from the Anonymous Runnable object!");
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		Thread t3 = new Thread( () -> System.out.println("Running from the lambda implementation ."));
		
		t3.start();
	}

}

class MyTask implements Runnable{
	// functional interface implemented 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Printing from the Runnable object, MyTask.");
		
		
		
	}
	
}

