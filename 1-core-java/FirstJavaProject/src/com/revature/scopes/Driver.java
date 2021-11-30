package com.revature.scopes;

public class Driver {

//	word = "hi"; // this is impossible because we can't acess a local variable from within a scope of another method
	
	public static void main(String[] args) {
		
		String word = "Hello";
		
		Driver d = new Driver();
		
		int product = d.multiply(42); // because this method is not static, it is at the INSTANCE scope, so we have to get it from the instance of
		//	an object
	
		System.out.println(product);
	
		MyClass mcObject = new MyClass();
		
		int x = MyClass.myStaticvariable;
		
		int z = mcObject.myInstanceVar; // we must capture it from the object itself
		
		int b = 5;
		
		while (b > 0) {
			
			int result = b * b;
			
			for (int i = result; i < 100; i++) {
			
				int test = i * 9000;
				System.out.println(i);
				
				for (int j = 0; j < result; j++ ) {
					// just demonstrating accessibility
				}
			}
			
//			 int o = i;
			
			System.out.println(result);
			
		}
		
		
	}
	
	public int multiply(int num) {
		
		// this object will be cleared from the heap
		MyClass mcObject = new MyClass();
		mcObject.myMethod();
		
		
		// this local variable is restricted to this method only
		int x = 100;
		return num * x;

	}

}
