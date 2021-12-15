package com.revature.lambdas;

public class StringDriver {

	public static void main(String[] args) {
		
		// Anonymous class! 
		String sillyString = doStringStuff(new /*_________*/ UpperConcat() { // interface

			@Override
			public String upperAndConcat(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.toUpperCase() + s2.toUpperCase();
			} 
		
		}, "String x", "String y");
		
		System.out.println(sillyString);
		

		Thread anonThread = new Thread(new /*____*/ Runnable() { 

			@Override
			public void run() {
				System.out.println("add some funcationality that we can see when we call .start() on this thread");
				
			} 
		});
		
		
		Thread lambdaThread = new Thread(() -> {
			
			System.out.println("This is the implementation for the run() method!!! ");
			
		});
	

	}
	
	public static String doStringStuff(UpperConcat uc, String s1, String s2) {
		
		return uc.upperAndConcat(s1, s2);
		
	}

}