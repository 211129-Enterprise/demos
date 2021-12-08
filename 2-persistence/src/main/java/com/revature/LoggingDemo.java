package com.revature;

import org.apache.log4j.Logger;

public class LoggingDemo {
	
	// STEP 1: Instantiate a Logger for the class (Bind it at the static (class) scope.
	private static Logger logger = Logger.getLogger(LoggingDemo.class);

	public static void main(String[] args) {
		

		/*
		 * Q: What is Logging?
		 * A: Logging is a method of reporting information during the execution of
		 * 	  a program (runtime). We typically use log files to inform devs and
		 * 	  System Administrators about what's happening within the program.
		 * 
		 * We have several logging levels:
		 * OFF 		- No logging at all
		 * 
		 * ALL		- Turns on all levels of logging
		 * 
		 * TRACE 	- Adds more information to our DEBUG logs
		 * 
		 * DEBUG 	- Primarily a logging level that is helpful for developers (turn on all of the following levels)
		 * 
		 * INFO		- Represent important business processes, used for defining when they have completed.
		 * 
		 * WARN		- Suggest that the application might be continued, but you should take extra caution
		 * 			  and that the current application state is "as expected" Generally speaking, System 
		 * 			  Administrators as well as similar roles (such as SREs) will monitor INFO logs to
		 * 			  track the application status.
		 * 
		 * ERROR	- Shouting that something has gone very wrong and should be investigated immediately.
		 * 
		 * FATAL 	- Very rare, but signals that something is terribly wrong and will
		 * 			  likely result in an application failure.
		 */
		
		
		// STEP 2. Use the logger
		logger.info("Application has started!");

//		//Force a stack overflow		
//		try {
//			recursiveMethod();
//		} catch(Error err) {
//			logger.error("Something has gone horribly wrong...");
//		}
		logger.info("Application has successfully completed!");
	}
	
	public static void recursiveMethod() {
		
		// Recursion is the act of a method invoking itself
		recursiveMethod();
	}

}
