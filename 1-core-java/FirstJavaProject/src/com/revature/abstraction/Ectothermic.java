package com.revature.abstraction;

public interface Ectothermic {
	
	// all fields of an interface are by default PUBLIC, STATIC and FINAL
	public static final int MIN_BODY_TEMP = -40;
	int MAX_BODY_TEMP = 90; // will always be PUBLIC, STATIC and FINAL
	
	
	// abstract and public
	public abstract void heatUp();
	
	void coolDown(); // still abstract and public, just abstracted and a
	
	// default methods also exist so that we can provide an implementation - since Java 8?
	default void saySomething() {
		
		System.out.println("I can provide an implementation here!");
		
	}

}
