package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Around("execution(* com.revature.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// capture the start  time of the method
		long start = System.currentTimeMillis();
		
		// give the method permission to continue executing
		joinPoint.proceed();
		
		// capture the end point of the method
		long end = System.currentTimeMillis();
		
		long timeTaken = end - start;
		
		
		// log the difference (a.k.a the time it took the method to execute).
		log.info("The time taken for {} to execute is {}", joinPoint, timeTaken);

	}
	
}
