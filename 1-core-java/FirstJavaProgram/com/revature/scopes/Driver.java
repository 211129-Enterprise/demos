package com.revature.scopes;

public class Driver {
	
//	word = "hi"; // this is impossible because we can't access a local variable from within a scope of another method

	public static void main(String[] args) {

		String word = "Hello"; //see line 5
		
		Driver d = new Driver();
		
		
		//because this method is not static, it is at the INSTANCE scope,
		//so we have to get it from the instance of an object
		int product = d.multiply(42);
		
		System.out.println(product);
		
		
		MyClass mcObj = new MyClass();
		
//		int x = mcObj.myInstanceVar; //Not ideal as MyClass is already laoded into memory so why load something new?
		
		int y = MyClass.myStaticVariable; //Captures from MyClass already loaded into memory
		int x = mcObj.myInstanceVar; //Must be captured from object itself
		
		
		int b = 5;
		
		while(b < 0) {
			int result = b * b;
			
			for(int i = result; i < 100; i++) {
				int test = i * 9000;
				System.out.println(i);
				
				for(int j = 0; j < result; j++) {
					//Just demonstrating accessibility
				}
			}
			
			//int o = i; //Can't be accessed because it is on a different block level
			System.out.println(result);
		}
	}
	
	//Instance scope
	public int multiply(int num) {
		
		//this object will be cleared from the heap (garbage collection) once the stack frame ends
		MyClass mcObj = new MyClass();
		mcObj.myMethod();
		
		//this local variable is restricted to this method only
		int x = 100;
		
		return num * 100;
	}

}
