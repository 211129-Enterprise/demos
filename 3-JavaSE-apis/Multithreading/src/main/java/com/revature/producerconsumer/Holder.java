package com.revature.producerconsumer;

public class Holder {
	int contents = 0;
	private boolean isAvailable = false;



public synchronized void setVal(int val) {
		
		// isAvailable == true
		while (isAvailable) {
			
			// this method will be invoked by the producer
			
			try {
				wait(); // This method forces the current thread to wait until some other thread
					   // invokes notify() or notifyAll() on the same object
						// this toggles a an object's monitor
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		// if !isAvailable ....
		contents = val;
		isAvailable = true;
		
		notifyAll(); 		
	}
	
	public synchronized int getVal() {
		
		// this method will return the value of the holder and will be invoked by the COnsumer
		
		// isAvailable == true
		while (!isAvailable) {
			
			// this method will be invoked by the producer
			
			try {
				wait(); // This method forces the current thread to wait until some other thread
					   // invokes notify() or notifyAll() on the same object
						// this toggles a an object's monitor
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		isAvailable = false;		
		
		notifyAll();
		
		return contents;
		
	}
    	
}
