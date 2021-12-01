package com.revature.scopes;

public class Driver {

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

	}
	System.out.println(p4.hashCode());
	System.out.println(p5.hashCode());

	System.out.println("=====================================");

	// Liskov Substitution Priciple - google
	Person e1 = new Employee("Larry", 45, 6.2, 270, "Finance");
	// e1 = new Artist(); // this is the Liskov Substitution Priciple at work 

	String name = e1.getName();
	System.out.println(name);

	((Employee) e1).getDept();

//	e1.name = "Garry";
	e1.setName("Garry");


}