package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Cross-Cutting Concern
 * 
 * A concern is a term that refers to a part of the system divided by functionality
 * 
 * A cross-cutting concern is a concern (like logging) that is applicable throughout the application
 * and it affects the entire application.
 * 
 * For example:
 * - Logging
 * - Security
 * - Data transfer
 *
 */
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @throws Throwable 
	 * @ARound is an advice type which ensures that advice can be run
	 * before AND after method execution
	 */
	
	// We're going to intercept all methods in the business layer and return the amount of time it takes to execute
	@Around("execution(* com.revature.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// capture the start time of the method
		long start = System.currentTimeMillis();
		
		// give the method permission to continue executing
		joinPoint.proceed();
		
		// capture the end point of the method
		long end = System.currentTimeMillis();
		
		long timeTaken = end - start;
		
		// log the difference (time it took to execute)
		log.info("The time taken for {} to execute is {} milliseconds", joinPoint, timeTaken);
	}
	
}
