package com.revature;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("myNumGenerator")
public class NumberGeneratorImpl implements NumberGenerator {

	private final Random random = new Random();
	
	// fields 
	private int maxNumber = 100;
	
	public int next() {
	
		return random.nextInt(maxNumber);
	}

	public int getMaxNumber() {
	
		return maxNumber;
	}
	
}
