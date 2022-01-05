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

	@After("execution(* com.revature.business.*.*(..))")
	public void after(JoinPoint joinPoint) {

		log.info("after execution of {} ", joinPoint);

	}

	@AfterReturning(value = "execution(* com.revature.business.*.*(..))",
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {

		log.info("{} returned value of {} ", joinPoint, result);

	}
	
	@AfterThrowing(
			value = "execution(* com.revature.business.*.*(..))",
			throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object result) {
		
		log.info("{} throws exception {} ", joinPoint, result);
		
	}

}
