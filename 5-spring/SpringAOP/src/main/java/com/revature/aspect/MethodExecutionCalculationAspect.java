package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
<<<<<<< HEAD
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

=======
 * Cross Cutting Concern
 * 
 *  A concern is a term that refers to a part of the system divided by functionality
 *  
 *  A crosscutting concern is a concern which is applicable throughout the entire application
 *  and it affects the entire application.
 *  
 *  For example: 
 *  - logging
 *  - security
 *  - data transfer
 */

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
>>>>>>> main
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @throws Throwable 
<<<<<<< HEAD
	 * @ARound is an advice type which ensures that advice can be run
	 * before AND after method execution
	 */
	
	// We're going to intercept all methods in the business layer and return the amount of time it takes to execute
	@Around("execution(* com.revature.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// capture the start time of the method
=======
	 * @Around is an advice type which ensures that advice can be 
	 * run before AND after method execution
	 */
	// we're gping to intercept all method in the business layer and return the amount of time it takes for it to execute
	
	@Around("execution(* com.revature.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// capture the start  time of the method
>>>>>>> main
		long start = System.currentTimeMillis();
		
		// give the method permission to continue executing
		joinPoint.proceed();
		
		// capture the end point of the method
		long end = System.currentTimeMillis();
		
		long timeTaken = end - start;
		
<<<<<<< HEAD
		// log the difference (time it took to execute)
		log.info("The time taken for {} to execute is {} milliseconds", joinPoint, timeTaken);
	}
	
=======
		
		// log the difference (a.k.a the time it took the method to execute).
		log.info("The time taken for {} to execute is {}", joinPoint, timeTaken);

	}
	
	// Weaving - the process of intercepting  a method where we specify a pointcut 
	// Weaver - the framework that does this (Spring AOP which used AspectJ) 
	
	
	

>>>>>>> main
}
