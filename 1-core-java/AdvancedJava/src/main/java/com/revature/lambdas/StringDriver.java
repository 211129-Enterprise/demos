package com.revature.lambdas;

public class StringDriver {
	public static void main(String[] args) {
		
		
	//Anonymous class way	
	
		String sillyString = doStringStuff(new UpperConcat() {
			@Override
			public String upperAndConcat(String s1, String s2) {
				return s1.toUpperCase() + s2.toUpperCase();
			}
		}, "String x ", "String y");
		System.out.println(sillyString);
		
		
		
		Thread anonThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("add some functionality that we can see when we call .start() on this thread.");
			}
		});
		
		//lambda ========================================
		Thread lambdaThread = new Thread(() -> {
				System.out.println("This is the implemenation for the run() method!!!");
		});
		
		
		
		
	}
	
	
	public static String doStringStuff(UpperConcat uc , String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}
	
}	
