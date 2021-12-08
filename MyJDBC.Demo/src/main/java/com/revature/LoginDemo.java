package com.revature;

import org.apache.log4j.Logger;

public class LoginDemo {
	/*
	 * Logging is a method of reporting information during the excution of a program
	 * 
	 * Logging levels: 
	 * 		-
	 * 
	 */
	
	private static Logger logger = Logger.getLogger(LoginDemo.class);
	
	public static void main(String[] args) {
		// step 1 : instatiate a logger 
		logger.info("Aplication has started");
		
		try {
		recursifMethod();
		}catch(Error e) {
		logger.error("something went really wrong");
		}
		logger.info("Aplication succefully complete");
		
		
	}
	
	public static  void recursifMethod() {
		recursifMethod();
	}
	

}
