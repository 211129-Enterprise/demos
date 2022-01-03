package com.revature;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

	// C O N S T A N T S
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	
	// F I E L D S
	@Autowired
	private Game game;
//	private final Game game;
//	
//	
//	
//	// C O N S T R U C T O R
//	public MessageGeneratorImpl(Game game) {
//		this.game = game;
//	}



	// P U B L I C   M E T H O D S
	@PostConstruct // Spring Bean Life cycle callback
	public void init() {
		log.info("DI has finished and the game = {}", game);
	}
	
	
	@Override
	public String getMainMessage() {
		return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can YOU guess it?"; 
	}



	@Override
	public String getResultMessage() {
		if(game.isGameWon()) {
			return "You guessed it! The number was " + game.getGuess();
		} else {
			return "You lose, good day sir!";
		}
	}
	
	
}
