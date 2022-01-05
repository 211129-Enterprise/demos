package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect //An aspect is a modularization of a concern that cuts across multiple classes
		//We define what we want to do when we intercept a method from a specific class
@Configuration 	// This tells Spring to configure this aspect into the global Application Context
				// = @Configuration informs Spring that this class interacts with your beans
public class BeforeAspect {
	
	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// Use advice to declare WHEN we want to do something.
		// We add a PointCut to inform Spring of the thing we're intercepting 
	// declare the method that outlines what we want to do.
	@Before("execution(* com.revature.data.*.* (..))") // Execution( of all methods PACKAGE of all classes of all return types regardless of parameters
	public void before(JoinPoint joinPoint) {
		
		//logger.info("Checking for user access"); // <-- Example of when you might use all of this
		
		// what we want to do, which is log that we're intercepting.
		logger.info("Intercepted Method call of {}", joinPoint);
		// Join Point is the opportunity to intercept which ialways a method. 
		// The PointCut is the specific pattern of methods that we're intercepting
		// Aspect is the combination of advice plus pointcut
		
		/*
		 * Restaurant Analogy
		 * 
		 * The menu is the JoinPoint (All the foods that you can order)
		 * Your order is the PointCut (the specific foods you order aka pattern)
		 */
	
	}
	
	
	// BEFORE any method in the data layer is called, I want to intercept it
	// and log its info and that I'm intercepting it.
}
