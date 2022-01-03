package com.revature;

import javax.annotation.PostConstruct;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageGeneratorImpl implements MessageGenerator {
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	private final Game game;
	
	public MessageGeneratorImpl(Game game) {
		this.game = game;
	}
	
	@PostConstruct
	public void init() {
		log.info("DI has finished, and the game = {}", game);
	}

	@Override
	public String getMainMessage() {
		
		return "number is between " + game.getSmallest() + " and " + game.getBiggest() + ;
	}

	@Override
	public String getResultMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
