package com.revature;

public class HelloWorld {
	public static void main(String[] args) {
		Integer obj1 = new Integer(20);
		Integer obj2 = new Integer("20");
		System.out.println("Hello from the IDE"+ (obj1 == obj2));
	}
}
