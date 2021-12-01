package com.revature.abstraction;

public interface Ectothermic {

	// all fields of an interface are by default PUBLIC STATIC and FINAL
	int MIN_BODY_TEMP = -40;
	int MAX_BODY_TEMP = 900;
	
	//by default all methods in an interface are ABSTRACT AND PUBLIC
	void heatUp();
	void coolDown();

	//default methods also exist and are the only way to implement a method in an interface -- since java 8?
	default void saySomething() {
		System.out.println("I can provide an implementation here");
	}
	
}
