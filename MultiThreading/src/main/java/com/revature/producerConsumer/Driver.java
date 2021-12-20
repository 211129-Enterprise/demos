package com.revature.producerConsumer;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Holder data = new Holder();
		int numValuesToGenerate = 10 ;
		Thread producerThread = new Thread(new Producer(data, numValuesToGenerate));
		Thread consumerThread = new Thread(new Consumer(data, numValuesToGenerate));
		
		System.out.println("Strating threads ");
		
		producerThread.start();
		consumerThread.start();

	}

}
