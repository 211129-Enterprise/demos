package com.revature.lambdas;

public class StringDriver {

	public static void main(String[] args) {
		
		// Anonymous class!
		String sillyString = doStringStuff(new /* __imagine_name_here__ */ UpperConcat() { // new __omitting_class_name__ that implements UpperConcat(){}

			@Override
			public String upperAndConcat(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.toUpperCase() + " " + s2.toUpperCase();
			}
			
		}, "String x", "String y");

		
		System.out.println(sillyString);
		
		
		
		Thread anonThread = new Thread(new Runnable() { // We're not creating a runnable object, we're implementing it from some unnamed class... hence ANONYMOUS classes

			@Override 
			public void run() { //NOTE, RUN is a FUNCTIONAL INTERFACE because it only has one method that you need to implement.
				System.out.println("Add some functionality that we can see when we call .start()");
				
			}
			
			
		});
		
		
		
		Thread lambdaThread = new Thread(() -> {
			
			// Run method is implied when using a FUNCTIONAL INTERFACE with a LAMBDA EXPRESSION
			System.out.println("This is the implementation for the run() method!!!");
			
		});
		
		
		
		
		
		
		//String lambdaSillyString = doStringStuff();
		
	}
	
	public static String doStringStuff(UpperConcat uc, String s1, String s2) {
		
		return uc.upperAndConcat(s1, s2);
	}

}
