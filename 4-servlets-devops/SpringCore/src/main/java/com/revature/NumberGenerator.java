package com.revature;

public interface NumberGenerator {
	
	// produce a number with next()
	int next();
	
	// we need a max Number to determine the range of 0 - maxNum for the Random
	int getMaxNumber();

}