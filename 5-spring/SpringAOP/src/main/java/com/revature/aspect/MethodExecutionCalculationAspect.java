package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration // Tell Spring that it interacts with our beans
public class MethodExecutionCalculationAspect {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * @Around is an advice type which ent hat advice can be run
	 * before AND after method execution.
	 */
	// We're going to intercept all methods in the buness layer and
	// return the amount of time it takes for it to execute.
	@Around("execution(* com.revature.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// We have to capture the start time of the method
		long start = System.currentTimeMillis();
		
		// Give the method permission to continue executing
		joinPoint.proceed();
		
		// Capture the end point of the method
		long end = System.currentTimeMillis();
		
		long timeTaken = end - start;
		
		// Log the difference (aka: the time it took the method to execute)
		log.info("The time taken for {} to execute is {}", joinPoint, timeTaken);
		
	}
	
	
	// Weaving - The process of intercepting a method where we specify a PointCut
	// Weaver - The framework that does this (Spring AOP which uses AspectJ)
	
}
