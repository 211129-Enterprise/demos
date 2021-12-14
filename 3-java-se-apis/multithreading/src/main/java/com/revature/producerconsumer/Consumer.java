package com.revature.producerconsumer;

public class Consumer implements Runnable {

	public Holder data;
	int max;
	
	
	
	
	
	public Consumer(Holder data, int max) {
		
		this.data = data;
		this.max = max;
		
	}
	
	
	
	
	
	@Override
	public void run() {
		
		// Open a for loop and iterate up to the max
		for(int i = 0; i <= max; i++) {
			
			int currentVal = this.data.getVal();
			System.out.println("The CONSUMER got " + currentVal);
			
		}
		
	}
	
}
