package com.revature.scopes;

public class Driver {
	
//	word = "hi";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "Hello";
		
		Driver d = new Driver();
		
		int product = d.multiply(42);
				
		System.out.println(product);
		
		MyClass mcObj = new MyClass();
		
		int x = MyClass.myStaticVariable;
		
		int z = mcObj.myInstanceVar;
		
		int b = 5;
		
		while(b > 0) {
			int result = b * b;
			
			for (int i= result; i< 100; i++) {
				int test = i * 9000;
				System.out.println(i);
			}
			int o = i;
			System.out.println(result)
		}
	}
	
	public int multiply(int num) {
		int x = 100;
		
		return num * 100;
	}

}
