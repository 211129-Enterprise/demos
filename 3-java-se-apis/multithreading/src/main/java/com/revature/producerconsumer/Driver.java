package com.revature.producerconsumer;

public class Driver {

	public static void main(String[] args) {
		
		Holder data = new Holder();
		int numValuesToGenerate = 10;
		
		Thread producerThread = new Thread( new Producer(data, numValuesToGenerate) ); // Pass through the producer runnable object
		Thread consumerThread = new Thread( new Consumer(data, numValuesToGenerate) ); // Pass through the consumer runnable object
		
		System.out.println("Staring threads...");
		
		producerThread.start();
		consumerThread.start();
		
	}

}
