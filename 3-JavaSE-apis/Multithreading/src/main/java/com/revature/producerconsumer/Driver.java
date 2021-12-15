package com.revature.producerconsumer;

public class Driver {
	public static void main(String[] args) {
		Holder data = new Holder();
		
		int numValuesToGenerate = 10;
		
		Thread producerThread = new Thread(new Producer(data, numValuesToGenerate));
				
		Thread consumerThread = new Thread(new Consumer(data, numValuesToGenerate));
	}
}
