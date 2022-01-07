package com.revature;

public class ThreadCreation {
	/*
	 * ===============================================================
	 * ========== THERE ARE TWO MAIN WAYS TO CREATE THREADS ==========
	 * ===============================================================
	 * 
	 * (1) Implement Runnable interface and pass it to a new 
	 *     Thread's object's Constructor
	 * 
	 * (2) Extend Thread class, and create an object of that 
	 *     class.
	 * ===================== Both are equal! =========================
	 */

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunnableClass());
		
		Thread t2 = new Thread(() -> System.out.println("Running the Lambda Thread"));
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Running from anonymous class!");
			}
		});
		
		/**
		 * Thread Life Cycle
		 * 
		 * - New - when created
		 * - Runnable - its run() method has been implemented
		 * - Active (Running) thread - its start() method has been called
		 * - Non-Runnable (Blocked)
		 * - Terminated
		 */
		
		// Way #2 of creating  a thread:
		t1.start();
		t2.start();
		t3.start();
		Thread t4 = new MyThread();
		t4.setName("My Extended Thread Class Thread");
		t4.setPriority(Thread.MAX_PRIORITY);
		
		t4.start();
		
		
	}
	
	// As long as we declare a nested class as static (even if it's private) it means 
	// it belongs to the class that encloses it.
	private static class MyThread extends Thread { // inner, outer classes
		
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
		
	}
	
}



class MyRunnableClass implements Runnable {

	@Override
	public void run() {
		System.out.println("Running Runnable");
		
	}
	
}