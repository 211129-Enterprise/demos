package com.revature.util;

import org.apache.log4j.Logger;

public class Logging {
	//Step 1 : Instantiate a Logger for the class (bind it at the static (class) scope
	private static Logger logger = Logger.getLogger(Logging.class);
	
	
	public static void main(String[] args) {
		/*
		 * What is logging?
		 * Logging is a method of reporting information 
		 * during the execution of a program (runtime).
		 * We typically use log files to inform devs and System Admins about what's
		 * happening within the program.
		 * 
		 * We have several log levels:
		 * OFF- no logging at all
		 * ALL- Turns on all levels of logging.
		 * TRACE - Adds more information to our DEBUG logs
		 * DEBUG - Primarily a logging level that is helpful for Developers(turn on all of the following levels)
		 * INFO -  Represent important business processes, used for defining when they have completed
		 * 		and that the current application state is "as expected"
		 * 		Generally speaking, System Administrators as well as similar roles (such as SREs) will monitor INFO logs to track
		 * 		the Application Status
		 * 
		 * WARN -  Suggest that the application might be continued, but you should take extra caution
		 * ERROR - Shouting that something has gone very wrong and should be investigated immediately
		 * FATAL - Very rare, but signals that something is terribly wrong, and will likely result in application failure
		 * 
		 */
		logger.info("Application has started!");
		
		logger.info("Application has successfully completed!");
		
	}
}
