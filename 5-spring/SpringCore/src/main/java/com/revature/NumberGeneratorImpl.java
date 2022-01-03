package com.revature;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component("myNumGenerator") // We're identifying this class as a possible dependency (Spring Bean) for another class (which is GameImpl)
public class NumberGeneratorImpl implements NumberGenerator {

	// F I E L D S
	private final Random random = new Random(); // Object that creates random numbers
	private int maxNumber = 100;

	
	
	
	// P U B L I C M E T H O D S
	@Override
	public int next() {
		// Pass the upper bound of the range to produce random
		// number
		return random.nextInt(maxNumber);
	}

	@Override
	public int getMaxNumber() {
		return maxNumber;
	}

}
