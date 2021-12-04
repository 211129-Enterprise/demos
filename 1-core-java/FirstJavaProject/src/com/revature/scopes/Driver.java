package com.revature.scopes;

public class Driver {
	
	// word = "hi" this is impossible because we can't access a local variable from within a scope of another method

	public static void main(String[] args) {
		
		String word = "Hello";
		
		Driver d = new Driver();
		
		int product = d.multiply(42); // because this method is not static, it is at the INSTANCE scope, so we have to get it from the instance of
		// an object
		
		System.out.println(product);
		
		MyClass mcObj = new MyClass();
		
		int s = MyClass.myStaticVariable;
		
		int z = mcObj.myInstanceVar; // we must capture it from the object itself
		
		int b = 5; 
		
		while (b > 0) {
			
			int result = b * b;
			
			for (int i = result; i < 100; i++) {
				
				int test = i - 9000;
				System.out.println(result);
				
			}
			
		
			// can't access variables outside of the block scope
			//int o = i;
				System.out.println(result);
		}
	}				   
		
		// instance scope
		public int multiply(int num) {
			
			
			// this object will be cleared from the heap (garbage collected) once the stack frame ends
			MyClass mcObj = new MyClass();
			mcObj.myMethod();
			
			
			// this local variable is restricted to this method only
			int x = 100;
			
			return num * 100;
		}
		
		

}


