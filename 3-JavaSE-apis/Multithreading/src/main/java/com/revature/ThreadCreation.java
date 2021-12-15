package com.revature;

public class ThreadCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new RunnableClass());
		
		
				
		Thread t4 = new MyThread();
		
		t4.setName("My extended thread class thread");
		
		t4.setPriority(Thread.MAX_PRIORITY);
		
		
		
		t4.start();
				
	}
	
	private static class MyThread extends Thread {
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
	}

}

class RunnableClass implements Runnable {

	// thread life cycle
	
//	1. new
//	2. runnable
//	3. active (running)
//	4. non-running (blocked)
//	5. terminated
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}