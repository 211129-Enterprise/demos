package com.revature.lambdas;

public class StringDriver {

	public static void main(String[] args) {
		//Anonymous Class!
		String sillyString = doStringStuff(new UpperConcat()){
			
			@Override
			public String upperAndConcat(String s1, String s2) {
				
				return null
			}
		}, "String x", "String y");

	}
	
	public static String doStringStuff(UpperConcat uc, String s1, String s2) {
	
		return uc.upperAndConcat(s1, s2);
		
	}

}
