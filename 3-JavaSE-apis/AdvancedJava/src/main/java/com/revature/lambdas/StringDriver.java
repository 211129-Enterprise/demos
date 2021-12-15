package com.revature.lambdas;

public class StringDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sillyString = doStringStuff(new UpperConcat() {

			@Override
			public String upperAndConcat(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.toUpperCase() + s2.toUpperCase();
			}
			
		}, "string x", "string y");
		
		System.out.println(sillyString);

	}
	
	public static String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}

}
