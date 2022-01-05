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
	
	@Around("execution(* revature.business.*.*(..)")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		joinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long timeTaken = end - start;
		
		log.info("The time taken for {} to execute is {} ", joinPoint, timeTaken);

		
	}
	
}
