package com.revature.lambdas;

public class StringDriver {

	public static void main(String[] args) {
		
		// Anonymous class!
		String sillyString = doStringStuff(new UpperConcat() {

			@Override
			public String upperAndConcat(String s1, String s2) {
				return s1.toUpperCase() + s2.toUpperCase();	
			}
		
		}, "String x", "String y");
		
		System.out.println(sillyString);
		
		Thread anonThread = new Thread( new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thing");
			}
			
			
		});
		
		// Lambda
		
//		String billyString = doStringStuff(, "String x", "String y");
		
	}

	public static String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}
	
}
