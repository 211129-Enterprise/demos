package com.revature;

public class HelloWorld {
	// ctrl + spacebar after main to get suggestion 

 
 /*
  * 
  * 
  * 
  */
 
 boolean istrue = true;  //  1 bit;
 byte smallNumber = 120; // 1 bytes; max 127 ; min -128
 short shortNumber = 19209; 
 char letter = 'm';
 int standerNum = 10_000_000 ; // 32 bites ; 4 bytes;
 float dicimal = 3.4f; // 32 bits;
 double decimalBetter = 20.45 ; // 64 bits;
 long bigNumber = 1234566789;// 64 bits; 
 
 // Casting;
 
 
 
 // Widening casting (Implicit) automatic ;
 
 /* smaller value type to a bigger value type;
  * 
  * 
  * 
  */
 
 // Narrow Casting (Explicit)
 
 /*
  * Need Manual conversion from large to smaller ;
  */
 

 
	
 
 public static void main(String[] args) {
	 //sysout + ctrl + space
	  byte a = 40;
	 short b =a ;
	 
	 double dub = 909.3;
	 int integer = (int) dub;  // Narrow Casting (Explicit)
	
	String name = "My name ";
	
	 
	System.out.println("Hello world ...form IDE");
	System.out.println(integer);
	
	System.out.println(name + "is " + (a + b) + " years old");
	
	/*
	 * Wrapper Classes 
	 * 
	 * Class names of the primitive data type; 
	 * Because some data structure with java that works only with 
	 * objects
	 * 
	 * 
	 * An object is re-usble coponennt consisting of proprties and methods;
	 * 
	 * 
	 * A class is blue print of object;
	 * 
	 */
	int min = Integer.MIN_VALUE;
	
	System.out.println(min);
	
	// here we convert a primitive value into an Integer class
	
	Integer obj1 = new Integer(20);
	
	Integer obj2 = new Integer("2");
	
	int unboxing = Integer.valueOf(obj1);
	
	
	System.out.println("are they equal " +  (obj1 == obj2)); // => compare the refrenece in memory ;
	
	
	System.out.println("are they equl using equals" + (obj1.equals(obj2))); // => compare their value ;
	

	
}
 
 
 
 
 
 
 
 
}
