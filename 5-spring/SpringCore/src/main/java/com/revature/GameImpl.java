package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GameImpl implements Game {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

	// == fields ==
	@Autowired // The Spring IoC knows that this is a dependency of this class that is the IoC's responsibilty to handle
	private NumberGenerator numberGenerator; // question is how do we fulfill a dependency of this type?
	//Now we need to declare the implementation class as the object that gets injected into GameImpl object
	private int guessCount = 10;
	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;
	
	// Constructor that defines how this object is assembled
	
	/**
	 * Constructor that defines how this object is assembled
	 * 
	 * == Constructor Injection ==
	 */
//	public GameImpl(NumberGenerator numGen) {
//		// Note that I'm passing an interface, and not the implementation class
//		this.numberGenerator = numGen;
//	}
	
	// == Setter Injection ==
	
	public void setNumberGenerator(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}
	
	
	// == public methods ==
	@Override
	public void reset() {
		smallest = 0;
		guess = 0;
		remainingGuesses = guessCount;
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		log.debug("the number is {}", number);
	}


	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public int getGuess() {
		return guess;
	}

	@Override
	public void setGuess(int guess) {
		this.guess = guess;
	}

	@Override
	public int getSmallest() {
		return smallest;
	}

	@Override
	public int getBiggest() {
		return biggest;
	}

	@Override
	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	@Override
	public void check() {

		checkValidNumberRange();

		if (validNumberRange) {
			if (guess > number) {
				biggest = guess - 1;
			}

			if (guess < number) {
				smallest = guess + 1;
			}
		}

		remainingGuesses--;
	}

	@Override
	public boolean isValidNumberRange() {
		return validNumberRange;
	}

	@Override
	public boolean isGameWon() {
		return guess == number;
	}

	@Override
	public boolean isGameLost() {
		return !isGameWon() && remainingGuesses <= 0;
	}

	// == private methods ==
	private void checkValidNumberRange() {
		validNumberRange = (guess >= smallest) && (guess <= biggest);
	}

}
