package com.revature.lambdas;

public class ThreadDriver {
	
	public static void main(String[] args) {
		//here we will instantiate a thread that has the behavior of MyTask
		Thread t1 = new Thread(new MyTask());
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Printing from anonymous Runnable Object");
			}
		});
		t2.start();
		
		//how would you provide a method implementation for the run() method via a lambda expression.
		Thread t3 = new Thread(() -> System.out.println("Running from lambda expression implementation."));
		t3.start(); //running from the lambda expression implementation.
	}
}

//Create my own functional interface


class MyTask implements Runnable { //functional interface implemented by 

	@Override
	public void run() {
		// 
		System.out.println("Printing form the Runnable object, MyTask.");
		
	}
	
}
