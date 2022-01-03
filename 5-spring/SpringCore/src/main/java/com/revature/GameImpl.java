package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameImpl implements Game {

	
	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GameImpl.class); // Import from org.slf4j
	// We will need the dependencies for the Logging API to sue this

	
	
	// == fields ==
	@Autowired // The Spring IoC knows that this is a dependency of this class that is the IoC's responsibility to handle.
	private NumberGenerator numberGenerator; // Question is how we fullfill a dependency of this type?
	// Now we need to declare the implementation class as the object that gets injected into this GameImpl object
	private int guessCount = 10;
	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;

	
// C O N S T R U C T O R   I N J E C T I O N	
//	// Constructor that defines how this object is assembled
//	public GameImpl(NumberGenerator numberGenerator) {
//		// Note that I'm passing an interface and NOT the implementation class.
//		this.numberGenerator = numberGenerator;
//	}

	
// S E T T E R  I N J E C T I O N
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
		log.debug("the number is {}", number); // {} = placeholder for the value of the second param
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
	public void check() { // Checks the user's answer

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
