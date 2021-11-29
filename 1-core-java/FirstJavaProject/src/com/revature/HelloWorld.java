package com.revature;

public class HelloWorld {
	public static void main(String[] args) {
		
		System.out.println("Hello World ....from the IDE");
		
	
		/*
		 * Multi line 
		 * comment
		 * 
		 * Java has 8 Primitive Types
		 * 8 bits = 1 byte
		 * 
		 */
		
		boolean isCool = true; // 1 bit of memory (0 or 1) that represents true or false values
		byte reallySmallNumber = 127; // 8 bits (1 byte) of memory reserved - max=127,  min = -128
		short shortNumber = 32432; // 16 bits of reserve memory 
		char letter = 'm'; // 16 bits of memory that represents a character or numerical value of an ASCII character
		
		int standardNum = 10_000_000;// 32 bits of memory (4 bytes)	
		
		float lessPreciseDouble = 93.2f; // 32 bits of memory
		double decimal = 20.45; // 64 bits of reserved memory
		
		long bigNumber = 1234567L; // 64 bits
		
	}
}
