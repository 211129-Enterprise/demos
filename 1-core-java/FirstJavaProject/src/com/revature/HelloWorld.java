package com.revature;

public class HelloWorld {
	// ctrl + spacebar allows me to shortcut method signatures
	public static void main(String[] args) {
		// sysout + cntrl + space
		System.out.println("Hello World... from the IDE (Integrated development environment)");
		
		
		/**
		 * Multi-line comment
		 * Java has 8 primitive Types
		 * 
		 */
		// 8 bits = 1 byte
		
		boolean isCool = true; // 1 bit of memory
		byte reallySmallNumber = 127; // 8 bits of memory. max value: 127, -128 min value
		// ensuring type safety, what a short can reserve.
		short shortNumber; // 16 bits of memory. little bit larger than byte/
		char letter = 'm'; // 16 bit of mem. represents character or numerical value of an ascii character
		int standardNum = 10_000_000; // 32 bits of mem. equal to 4 bytes.
		// for decimals double is best practice. 
		double decimal = 20.45; // 64bits of mem
		// less precise:
		float fl = 93.2f; // 32 bits of mem.
		
		long bigNum = 1234567L; // 64 bits
		
		// java is statically types. you can not reassign a data type.
		
		// TYPE CASTING:
		
		// widening casting : implicit == automatic type conversion
		
		// narrow casting : explicit == manual
		
		// *contatenation*
		// java literals
	}
	
}
// run with keyboard " Cntrl + shift"