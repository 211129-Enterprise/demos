package com.revature.abstraction;

public interface Amphibious {
	
	// By default, all methods within an interface are ABSTRACT and PUBLIC
	// Whichever class implements this will be FORCED to implement its own swim()
	void swim();
}
