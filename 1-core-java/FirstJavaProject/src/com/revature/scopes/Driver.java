package com.revature.scopes;

public class Driver {
	
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
		
	}

}
