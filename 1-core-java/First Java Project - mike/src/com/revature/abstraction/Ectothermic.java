package com.revature.abstraction;

public interface Ectothermic {
	
	// all fields of an interface are by default PUBLIC, STATIC and FINAL
	public static final int MIN_BODY_TEMP = -40;
	public static final int MAX_BODY_TEMP = -40;

	void heatUp();
	
	void coolDown();
	
}
