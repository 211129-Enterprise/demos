package com.revature.producerConsumer;

public class Consumer  implements Runnable  {


	
	public Holder data ;
	int max ;
	
	public Consumer( Holder data, int max ) {
		this.data = data;
		this.max = max;
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0 ; i <= max ; i++ ) {
		int c =	this.data.getVal();
			System.out.println("The consumer got  : " + c);
		}
		
	}

}


