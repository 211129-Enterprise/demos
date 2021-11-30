package com.revature.scopes;

public class Driver {

	//word = "hi"; // this is impossible because it's outside the method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "hello";
		Driver d = new Driver();
		
		
		//int product1 = multpily(4); // doesn't work
		int product2 = d.multiply(4); // because method is not static it is at the instance scope, so can't be called without an instance
		
		MyClass mcObj = new MyClass();
		
		int x = MyClass.myStaticVariable;
		int z = mcObj.myInstanceVar;
		
		int b = 5;
		while (b > 0) {
			int result = b*b;
			for(int i = result; i < 100; i++) {
				int test = i*9000;
				System.out.println(i);
				System.out.println(test);
			}
		}
		
	}
	
	public int multiply(int num) {
		// this local variable is restricted to this method only, nothing else can access it.
		int x = 100;
		return num * x;
	}

}
