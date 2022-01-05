package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// after any methods in the business layer are triggered, log some info about it
	@After("execution(* com.revature.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		
		log.info("After execution of {}", joinPoint);
		
	}
	
	// what if we want to intercept and log the return of a method
	@AfterReturning(
			value="execution(* com.revature.business.*.*(..))",
			returning="result") // result is a placeholder for the return of this method
	public void after(JoinPoint joinPoint, Object result) {
		
		log.info("{} returned value of {}", joinPoint, result);
		
	}
	
	// Intercept any exceptions that were thrown by a method
	@AfterThrowing(
			value="execution(* com.revature.business.*.*())",
			throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		
		log.info("{} throws exception {}, joinPoint, exception");
	}
	
	
}
