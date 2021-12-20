package com.revature.producerConsumer;

public class Holder {
	
	int contents  = 0; // one thread will be a producer thread 
	private boolean isAavilable = false;
	
	/*
	 * 
	 * setVal() used by the producer 
	 * getVal() used by the consumer 
	 * 
	 */

	public Holder(int i) {
		// TODO Auto-generated constructor stub
	}



	public Holder() {
		// TODO Auto-generated constructor stub
	}



	public synchronized void setVal(int val) {
		
		while(isAavilable == true) {
			
			// this method will be invoked by the producer 
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		this.contents = val;
	
		this.isAavilable = false;
		
		notifyAll();
	
	}
	
	
	
	public synchronized int getVal() {
		
		while(isAavilable == false ) {
			
			// this method will be invoked by the producer 
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
		isAavilable = true;
		
		notifyAll();
		
		return contents;
	}
	
	
	
	
}
