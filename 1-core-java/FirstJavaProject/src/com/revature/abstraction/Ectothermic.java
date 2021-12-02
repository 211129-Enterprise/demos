package com.revature.abstraction;

public interface Ectothermic {
	int MIN_BODY_TEMP = -40;
	
	void heatUp();
	void coolDown();
	
	default void saySomething() {
		System.out.println("somthing");
	}
}
