package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration // tels the spring to configure this  aspect into the global application context
public class BeforeAspect {
	
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Before("execution(* com.revature.data.*.*(..) )")
	public void before(JoinPoint joinpoint) {
		
		log.info("Checking for user access. ");
		
		log.info("Intercepted Method call of {}", joinpoint );
		
		
		
		
		
	}

}
	