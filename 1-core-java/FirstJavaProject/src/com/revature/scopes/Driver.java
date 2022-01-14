package com.revature.scopes;

public class Driver {
<<<<<<< HEAD
	
	public int multiply(int x){
		int y = 5;//This is restricted to the method it cannot be referenced outside it.
		int z = x*y;
		return z;
	}

	public static void main(String[] args) {
		String word = "hello";
		
		Driver d = new Driver();
		
		int product = d.multiply(2);//Because this method is not static we must get it from a specific of the object. 
		System.out.println(product);
		
		System.out.println("This is a static variable from MyClass being called from outside it "+MyClass.myStaticVariable);
=======

	// word = "hi"; // this is impossible because we can't access a local variable from within a scope of another method
	
	public static void main(String[] args) {
		
		String word = "Hello";
		
		Driver d = new Driver();
		
		int product = d.multiply(42); // because this method is not static, it is at the INSTANCE scope, so we have to get it from the instnace of 
		// an object

		System.out.println(product);
		
		MyClass mcObj = new MyClass();
		
		int x = MyClass.myStaticVariable;
		
		int z = mcObj.myInstanceVar; // we must capture it from the object itself
		
		int  b = 5;
		
		while (b > 0) {
			
			int result = b * b;
			
			for (int i= result; i< 100; i++) {
				
				int test = i * 9000;
				System.out.println(result);
				
				for (int j=0; j< result; j++) {
					// just demonstrating acessability 
				}
				
			}
			
			// can't access variables outside of the block scope
			// int o = i;
			System.out.println(result);
			
		}
		
	}
	
	// instance scope
	public int multiply(int num) {
		
		// this object will be cleared from the heap[ (garbage collected) once the stack frame ends
		MyClass obj = new MyClass();
		obj.myMethod();
		
		
		// this local variable is restricted to this method only
		int x = 100;
		
		return num * 100;
>>>>>>> d828daa3e2b69e132493fdbbbf8ca90ffe1851db
		
	}

}
