package com.revature;

import org.apache.log4j.Logger;

public class LoggingDemo {
	
	private static Logger logger = Logger.getLogger(LoggingDemo.class);
	
	public static void main(String[] args) {
		logger.info("Application has started!");
		logger.info("Application has successfully completed!");
	}
	
	
}
