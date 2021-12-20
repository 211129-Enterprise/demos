package com.revature.lambda;

public class StringDriver {
	
	public static void main(String[] args) {
		
		// Anonymous class 
		
		String sillyString = doStringStuff(new UperConcat() {
			
			@Override
			public String upperCaseConct(String s1 , String s2) {
				// TODO Auto-generated method stub
				return  s1.toUpperCase() + s2.toUpperCase();
			}

			@Override
			public String upperCaseConct() {
				// TODO Auto-generated method stub
				return null;
			}

		
		}, "String X", "String Y");
		
		
		
		
		System.out.println(sillyString);
		
		
	
	}

	
	
	
	public static String doStringStuff(UperConcat us, String s1 , String s2) {
		
		return us.upperCaseConct(s1,s2);
	}
	
	
	
	
	
}
