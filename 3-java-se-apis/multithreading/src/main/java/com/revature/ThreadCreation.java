package com.revature;

public class ThreadCreation {
	
	/*
	 * ================================================
	 * ===== THERE ARE TWO WAYS TO CREATE THREADS =====
	 * ================================================
	 * 
	 * 		(1) Implement runnable interface and pass
	 * 		it to a new Thread object's constructor.
	 * 
	 * 		(2) Extend Thread class and create an
	 * 		object of that class.
	 * 
	 * ================ BOTH ARE EQUAL! ================
	 */

	public static void main(String[] args) {
		
		// Using separate class
		Thread t1 = new Thread(new MyRunnableClass());
		t1.start();
		/*
		 * ================================================
		 * THREADS HAVE LIFE CYCLES:
		 * 	- NEW = when created
		 * 
		 * 	- RUNNABLE = Its run() method has been implemented
		 * 
		 * - Active / running = Its start() method has been called
		 * 
		 * - Blocked / Non-runnable = something preventing it from 
		 * 							doing what it was designed for
		 * 
		 * - Terminated = can never run
		 * ================================================
		 */
		
		// Using Lambrdas
		Thread t2 = new Thread(() -> System.out.println("Running the LAMBDA thread!"));
		t2.start();
		
		
		
		
		// Using an anonymous class
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Running the ANON CLASS thread!");
				
			}
			
		});
		t3.start();
		
		
		
		
		// Using an inner class / nested class 
		Thread t4 = new MyThread();
		
		t4.setName("My Extended Thread Class Thread Pro Plus Deluxe");
		t4.setPriority(Thread.MAX_PRIORITY);
		t4.start();

	}
	
	
	// Example of an Inner / Nested class
	//
	// As long as we declare a nested class as static
	// - even if it is private - it means that it "belongs"
	// to the class that encloses it.
	private static class MyThread extends Thread{
	// If the class wasn't declared "static," it'd need the
	// an instance of the surrounding class, ThreadCreation,
	// to instantiate it.
		
		public void run() {
			System.out.println("Hello from the '" + this.getName() + "' thread.");
		}
	}

}


class MyRunnableClass implements Runnable{

	@Override
	public void run() {
		System.out.println("From my Runnable class.");
		
	}
	
}
