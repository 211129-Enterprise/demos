package com.revature;

import org.apache.log4j.Logger;

public class LoggingDemo {

	//Step 1. Instantiate a logger for the class( bind it at the static class scope)
	private static Logger logger = Logger.getLogger(LoggingDemo.class);
	
	public static void main(String[] args) {
		/**
		 * What is Logging?
		 * Is a method of reporting information during the execution of a program (runtime)
		 * We typically use log files to inform devs and system admins about what's happening within the program.
		 * 
		 * WE have Several Logging Levels:
		 * 
		 * OFF:No logging at all
		 * ALL: Turns on all levels of logging
		 * TRACE:Adds mor information to our DEBUG logs
		 * DEBUG: Primarily a logging level that is helpful for developers (turn on all of the following levels)
		 * INFO: Represent important business processes, used for defining when they completed
		 * 		and that the current application state is "as expected"
		 * 		Generally speaking, System admins as well as similar roles (such as SREs) will monitor INFO logs to track
		 * 		the application status
		 * 
		 * WARN:Suggest that the application might be continued, but you should take extra caution
		 * ERROR: Shouting that something has gone very wrong and should be investigated immediately
		 * FATAL: Very rare, but signals that something is terribly wrong, and will likely result in application failure
		 * 
		 */
		
		//Step 2. Use the logger
		
		logger.info("Application has started!");
		
		try {
			recursiveMethod();
		} catch (Error err) {
			logger.error("Something has gone horribly wrong...");
		}
		
		logger.info("Application has successfully completed!");
		

	}
	
	public static void recursiveMethod() {
		
		//recursion is the act of a method invoking itself
		recursiveMethod();
	}

}
