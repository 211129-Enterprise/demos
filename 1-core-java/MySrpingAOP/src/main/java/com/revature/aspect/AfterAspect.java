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
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());

	// advices
	@After("execution(* com.revature.business.*.*(..) )")
	public void after(JoinPoint joinpoint) {

		log.info("after execution of {}", joinpoint);

	}
	// advices
	// what is we want to intercept and log the return of a method
	@AfterReturning(	
			value = "execution(* com.revature.business.*.*(..))",
			returning="result")
	public void after(JoinPoint joinPoint, Object result) {

		log.info("{} returned value {}", joinPoint, result);

	}
	
	@AfterThrowing(
			value="execution(* com.revature.business.*.*(..))",
			throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		log.info("{} throws exception {}", joinPoint, exception);
	}
	

}
