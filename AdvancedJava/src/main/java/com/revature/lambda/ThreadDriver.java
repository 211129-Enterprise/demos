package com.revature.lambda;

public class ThreadDriver {
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyTask());
		t1.start();
		
		// how to do the same thing with anonomys class 
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			System.out.println("print from my anaomys  ");
				
			}
		});
		
		
		t2.start();
		
		Thread t3 = new Thread(()->System.out.println("print from lambda "));
		 
		t3.start();
		
	}
	
	
	
}

class MyTask implements Runnable{ // functional in

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Printing from the Runnable object , myTASK");
		
	}
	
}


