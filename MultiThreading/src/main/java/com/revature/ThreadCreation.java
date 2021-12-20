package com.revature;

public class ThreadCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread  t1 = new Thread(new MyRunnableClass());
		
		Thread t2 = new Thread(()-> System.out.println("print from lambda "));
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println("print form anonymys class");
				
			}
		});
		
		Thread t4 = new MyThread();
		t4.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	
	
	// as long as we declare a nested class as static it means it belongs to the class that enclose it 
	private static class MyThread extends Thread {
		
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
		
	}
	

}


class MyRunnableClass implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("print from runnable class");
		
	}
	
}