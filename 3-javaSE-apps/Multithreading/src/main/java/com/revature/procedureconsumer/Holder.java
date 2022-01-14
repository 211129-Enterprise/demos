package com.revature.procedureconsumer;

public class Holder {
	int contents = 0; //one thread will be a producer thread and produce by increasing the value from 0 to 10
	private boolean isAvailable = false;
	
	public /*synchronized*/ int setVal(int val) {
		while (isAvailable == true) {
			try {
				wait();//forces the current thread to invoke notify() or notifyAll()
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		contents = val;
		isAvailable = true;
		
		notifyAll();	
		
		return contents;
	}
	
	public /*synchronized*/ int getVal() {
		while (isAvailable == true) {
			try {
				wait();//forces the current thread to invoke notify() or notifyAll()
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		isAvailable = false;
		
		notifyAll();		
		
		return contents;
	}

}
