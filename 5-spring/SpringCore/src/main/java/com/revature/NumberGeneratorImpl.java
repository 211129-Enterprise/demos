package com.revature;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("myNumGen") // We're identifying this class as a possible dependency (Spring Bean) for another class (GameImpl)
public class NumberGeneratorImpl implements NumberGenerator {
	
	// == fields == 
	private final Random random = new Random();
	
	private int maxNumber = 100;
	
	
	// == public methods ==
	@Override
	public int next() {
		return random.nextInt(maxNumber); // pass the upper bound of hte range to produce random number
	}

	@Override
	public int getMaxNumber() {
		return maxNumber;
	}

}
