package com.revature;

public class ThreadCreation {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunnableClass());
		
		Thread t2 = new Thread( () -> {System.out.println("Running the Lambda class");});
		
		Thread t3 = new Thread (new Runnable() {
			public void run() {
				System.out.println("Running from the anon class");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		Thread t4 = new MyThread();
		t4.setName("My extended thread class thread");
		t4.setPriority(Thread.MAX_PRIORITY);
		t4.start();
		
		/*
		 * Thread Life Cycle
		 * New-The thread is created
		 * Runnable-The run() method has been implemented
		 * Active-The start() method has been invoked
		 * Non-Runnable-The thread is somehow blocked
		 * Terminated-
		 */
	}
	//This is a nested class, even though it is private it belongs to the enclosing class
	private static class MyThread extends Thread {
		public void run() {
		System.out.println("Hello from "+this.getName());
		}
	}

}

class MyRunnableClass implements Runnable{

	public void run() {
		System.out.println("From runnable");
	}
	
}