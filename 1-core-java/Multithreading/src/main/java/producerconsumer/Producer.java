package producerconsumer;

public class Producer implements Runnable {

	
	public Holder data;
	int max;
	
	public Producer(Holder data, int max) {
		this.data = data;
		this.max = max;
	}

	@Override
	public void run() {
		// open a for loop, iterate up to the max
		for (int i=0; i<=max; i++) {
			
			this.data.setVal(i);
			System.out.println("The producer put: " + i);
		}
	}

}