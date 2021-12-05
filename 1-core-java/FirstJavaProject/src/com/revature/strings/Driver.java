package com.revature.strings;

public class Driver {

	public static void main(String[] args) {
		
		String str1 = "hello"; // pool
		String str2 = "hello"; // pool
		System.out.println(str1 == str2);
		
		String str3 = new String("hello"); // heap
		System.out.println(str1 == str3);
		
		String str4 = "hel" + "lo"; // pool
		System.out.println(str1 == str4);
		
		String str5 = str1 + ""; // heap
		System.out.println(str1 == str5);
		
		String str6 = str5.intern(); // pool
		System.out.println(str1 == str6);
		
		
		StringBuilder stringBuilder = new StringBuilder("hel");
		stringBuilder.append("lo");
		System.out.println(stringBuilder.toString() == str1);
		
		String string = stringBuilder.toString().intern();
		System.out.println(str1 == string);
	}
	
}
