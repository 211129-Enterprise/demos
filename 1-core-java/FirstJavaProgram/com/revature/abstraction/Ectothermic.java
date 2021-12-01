package com.revature.abstraction;

public interface Ectothermic {

	
	// All fields of an interface are by default PUBLIC, STATIC, and FINAL
	public static final int MIN_BODY_TEMP = -40;
	int MAX_BODY_TEMP = 90; // Also PUBLIC, STATIC, FINAL by default
	
	
	//BY default, abstract and public
	public abstract void heatUp();
	void coolDown(); //still abstract and public
	
	//Default methods also exist so that we can provide an implementation
	default void saySomething() {
		System.out.println("I exist therefore I say");
	}
}

