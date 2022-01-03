package com.revature;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("myNumGenerator") // We're identifying this class as a possible dependency (Spring Bean) for another class (which is GameImpl) 
public class NumberGeneratorImpl implements NumberGenerator{

	// == fields ==
	private final Random random = new Random(); // object that creates random numbers
	
	private int maxNumber = 100;

	
	// == public methods
	@Override
	public int next() {
		return random.nextInt(maxNumber); // pass the upper bound of the range to produce random number
	}

	@Override
	public int getMaxNumber() {
		return maxNumber;
	}

}
