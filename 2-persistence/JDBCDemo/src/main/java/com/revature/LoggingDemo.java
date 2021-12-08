package com.revature;

import org.apache.log4j.Logger;

public class LoggingDemo {

	
	private static Logger logger = Logger.getLogger(LoggingDemo.class);
	
	public static void main(String[] args) {
		
		
		logger.info("Application has started");
		
		try {
			recursiveMethod();
		}catch (Error err) {
			logger.error("Something has gone horribly wrong ... ");
		}
		
		
		
		logger.info("Application has successfully completed");
		

	}
	
	
	public static void recursiveMethod() {
		
		recursiveMethod();
	}

}
