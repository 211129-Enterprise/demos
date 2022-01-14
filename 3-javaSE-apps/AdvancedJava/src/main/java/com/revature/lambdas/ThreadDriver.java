package com.revature.lambdas;

public class ThreadDriver {
	public static void main(String[] args) {
		
		//instantiates a thread with the behavior of MyTask
		Thread t1 = new Thread(new MyTask());
		
		t1.start();
		
		//How would we do the same with an anonymous class
		//Create called with ref variable tw and its method says Printing from the anonymous runnable object
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Printing from the Anonymous Runnable object!");
			}
		});
		
		t2.start();
		
		Thread t3 = new Thread(() -> System.out.println("Running from the lambda expression implementation"));
		
		t3.start();
	}
}

class MyTask implements Runnable {//functional interface implemented by 

	@Override
	public void run() {		
		System.out.println("Printing from runnable object, MyTask");
	}
	
}