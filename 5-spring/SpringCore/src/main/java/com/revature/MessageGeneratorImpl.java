package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class MessageGeneratorImpl implements MessageGenerator {
	
	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	// == fields ==
	@Autowired
	private Game game;
	
//	// == constructor ==
//	public MessageGeneratorImpl(Game game) {
//		this.game = game;
//	}
//	
	
	// == public methods ==
//	@PostConstruct // Spring Bean Lifecycle callback
	public void init() {
		log.info("DI has finished, and the game = {}", game);
	}
	
	
	@Override
	public String getMainMessage() {
		return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
	}

	@Override
	public String getResultMessage() {
		if (game.isGameWon()) {
			return "You guessed it! The number was " + game.getNumber();
		} else {
			return "You didn't guess it";
		}
		
	}

}
