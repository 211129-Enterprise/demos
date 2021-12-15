package com.revature.lambdas;

public class ThreadDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyTask());
		
		t1.start();
		
		Thread t2 = new Thread( new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		t2.start();
		
		Thread t3 = new Thread(() -> System.out.println("Running from lambda expression"));
		
		t3.start();
	}

}


class MyTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Printing fomr the Runnable object, MyTask");
		
	}
	
}
