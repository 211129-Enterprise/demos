package producerconsumer;

public class Driver {
	
	public static void main(String[] args) {
		
		Holder data = new Holder();
		int numValuesToGenerate = 10;
		
		Thread producerThread = new Thread(new Producer(data, numValuesToGenerate)); // pass thru the producer runable object
		Thread consumerThread  = new Thread(new Consumer(data, numValuesToGenerate)); // pass thru the consumer runnable object
		
		System.out.println("Starting threads");
		
		
		producerThread.start();
		consumerThread.start();
		
		
		// introduce the join() method
		
		
	}

}