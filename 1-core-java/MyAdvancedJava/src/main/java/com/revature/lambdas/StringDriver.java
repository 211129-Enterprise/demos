package com.revature.lambdas;

public class StringDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// anonymous class
		String sillyString = doStringStuff(new UpperConcat() {

			@Override
			public String upperAndConcat(String s1, String s2) {
				// TODO Auto-generated method stub
				
				
				return s1.toUpperCase() + s2.toUpperCase();
			}
			
		}, "String x", "String y");
		
		System.out.println(sillyString);
		//String s1 = "String x";
		//String s2 = "String y";
		
		String lambdaSillyString = doStringStuff((s1,s2) -> s1.toUpperCase() + s2.toUpperCase(), "String x", "String y");
		System.out.println(lambdaSillyString);
		
		
		
		Thread anonThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Add  some functionality");
				
			}
			
		});
		
		Thread lambdaThread = new Thread(() -> {
			System.out.println("This is the implementation for the run() method.");
		});
	}
	
	public static String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
		
	}

}
