package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD
/**
 * An Aspect is a modularization of a concern that cuts across multiple classes
 * We define what we want to do when we intercept a method from a specific class
 */

@Aspect
@Configuration // this tells Spring to configure this aspect into the global ApplciatioNContext
=======
@Aspect // an aspect is a modularization of a concern that cuts across multiple classes
		// We define what we want to do when we intercept a method from a specific class
@Configuration // this tell Spring to configure this aspect into the global ApplicationContext
			   // = @Configuration informs Spring that this class interacts with your beans
>>>>>>> main
public class BeforeAspect {
	
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
<<<<<<< HEAD
	// Use advice to declare WHEN we want to do something
		// we add a PointCut to inform Spring of the thing we're intercepting
	// declare the method that outlines WHAT we want to do
	@Before("execution(* com.revature.data.*.*(..))") // execution(* PACKAGE.*.*(..)) Spring Expression Language
=======
	// Use advice to declare WHEN we want to do something , 
		// we add a PointCut to inform Spring of the thing we're intercepting
	// declare the method that outlines WHAT we want to do
	@Before("execution(* com.revature.data.*.*(..))")// execution(* PACKAGE.*.*(..)) // Spring Expression Language
>>>>>>> main
	public void before(JoinPoint joinpoint) {
		
		log.info("Checking for user access");
		
		log.info("Intercepted Method call of {}", joinpoint);
		
		// Join Point is the opportunity to intercept (always a method)
		// PointCut is the specific pattern of methods that we're intercepting
		// Aspect is the combo of advice + pointcut
		
		/**
		 * Restaurant Analogy
		 * 
<<<<<<< HEAD
		 * The menu is the JoinPoint (all the foods that you can order)
		 * Your order is the PointCut (the specific combination of foods that you want aka Pattern)
		 */
		
	}
	
	// BEFORE any method in the data layer is called, I want to intercept it and log its info and that I'm intercepting it
=======
		 * The menu is the JoinPoint (all the foods that you can order) 
		 * Your order is the PointCut (the specific foods your order a.k.a pattern)
		 */

	}
	
	// BEFORE any method in the data layer is called, I want to intercept it and log it's info and that I'm intercepting it
	

>>>>>>> main
}
