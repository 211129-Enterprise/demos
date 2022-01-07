package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.business.Business1;
import com.revature.business.Business2;

@SpringBootApplication
<<<<<<< HEAD
public class SpringAopApplication implements CommandLineRunner {
=======
public class SpringAopApplication implements CommandLineRunner{ 
>>>>>>> main
	
	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
<<<<<<< HEAD
	// we need to inject the service beans into this class to use them
	// autowire business 1
	@Autowired
	private Business1 business1;
=======
	// we need to inject the Service Beans into this class to use them
	// autowire business 1
	@Autowired
	private Business1 business1;
	
>>>>>>> main
	// autowire business 2
	@Autowired
	private Business2 business2;

	/**
<<<<<<< HEAD
	 * SpringApplication.run bootstrap (self-start) a spring application
=======
	 * SpringApplication.run bootstrap (self-start) a spring application 
>>>>>>> main
	 * as a stand-alone application from the main method.
	 * 
	 * It creates an appropriate ApplicationContext instance and loads beans
	 * that are marked as @Bean or any Components marked with their respective
	 * annotations @Repository @Controller @Service.
	 * 
<<<<<<< HEAD
	 * If you have Spring Web Starter as a dependency, it also starts an embedded tomcat server
	 * and deploys YOUR APP on the server at port 8080 (default port for tomcat)
	 * 
	 */
	
=======
	 * IF you have Spring Web Starter as a dependency it also sytarts an embedded tomcat server
	 * and deploys YOUR APP on the server at port 8080 (default for tomcat)
	 */
>>>>>>> main
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

<<<<<<< HEAD
	
	// The only reason we implement ComandLineRUnner functional interface is to continue 
	// executing code outside of the main method of the Spring Boot App
=======
	// The only reason we implementd CommandLineRunner functional interface 
	// is to continue executing code outside of the main method of the Spring Boot App
>>>>>>> main
	
	@Override
	public void run(String... args) throws Exception {
		
		// call the calculateSomething() methods from the business layers
<<<<<<< HEAD
		log.info(business1.calculateSomething()); // we are logging the returned value of the method which is from the business layer
		log.info(business2.calculateSomething());
		
		// Goal: intercept the calls from the business layer -> data layer and print information about
		// the methods being called. We do this with AOP
		
	}
	
	// Weaving - the process of intercepting a method where we specify a PointCut (specification)
	// Weaver - the framework that does this (Spring AOP which uses AspectJ)
=======
		log.info(business1.calculateSomething()); // we are logging (printing) the returned value of the method which is from the dao
		log.info(business2.calculateSomething());
		
		// Goal: intercept the calls from the business layer -> data layer and print information about the 
		// methods being called. We do this with AOP
	}

>>>>>>> main

}
