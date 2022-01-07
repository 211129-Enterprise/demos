package com.revature;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class MessageGeneratorImpl implements MessageGenerator {
	
=======
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageGeneratorImpl implements MessageGenerator {

>>>>>>> main
	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	// == fields ==
	@Autowired
	private Game game;
	
<<<<<<< HEAD
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
	
	
=======
	// == public methods ==
	@PostConstruct // Spring Bean Life Cycle callback
	public void init() { // As SOON as DI is fulfilled, that's when this method will be called
		log.info("DI has finished, and the game = {}", game);
	}
	
>>>>>>> main
	@Override
	public String getMainMessage() {
		return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
	}

	@Override
	public String getResultMessage() {
		if (game.isGameWon()) {
<<<<<<< HEAD
=======
			
>>>>>>> main
			return "You guessed it! The number was " + game.getNumber();
		} else {
			return "You didn't guess it";
		}
<<<<<<< HEAD
		
	}

=======
	}
>>>>>>> main
}
