package com.revature.aspect;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@After("execution(* com.revature.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}
	
	@AfterReturning(value="execution(* com.revature.business.*.*(..))",
			returning="result")
	public void after(JoinPoint joinPoint, Object result) {
		logger.info("after execution of {}", joinPoint);
	}
	
	@AfterThrowing(value="execution(* com.revature.business.*.*(..))",
			throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		logger.info("{} throws exception {}", joinPoint, exception);
	}
	
}
