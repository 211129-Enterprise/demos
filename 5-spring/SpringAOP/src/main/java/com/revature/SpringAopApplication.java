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
public class SpringAopApplication implements CommandLineRunner{
	
	// Logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// We need to inject the business beans into this class to use them
	// Autowire business 1
	@Autowired
	private Business1 business1;
	
	// Autowire business 2
	@Autowired
	private Business2 business2;	
	

	/**
	 * SpringApplication.run bootstrap (self start) a spring application
	 * as a stand-alone application from the main method.
	 * 
	 * It creates an appropriate ApplicationContext instance and loads beans
	 * that are marked as @Bean or any components marked with their respective
	 * annotations like @Repository, @Controller, or @Service.
	 * 
	 * If you have Spring Web Starter as a dependency, it also starts an embedded
	 * Tom cat web server and deploys YOUR APP on the server at Port 8080
	 * which is the default for Tomcat.
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}


	// create separate method called run()
	// The oyreason we implemented CommandLineRunner functional interface
	// is to continue executing code outside of the main method of the
	// Spring Boot App
	@Override
	public void run(String... args) throws Exception {
		
		// Call the calculateSomething() methods from the business layers
		log.info(business1.calculateSomething()); // We are logging / printing the return value of the
		log.info(business2.calculateSomething()); // method which is from the dao layer
		
		// GOAL: Intercept the calls from the business layer to the data layer and print information about
		// 		 the methods being called. We do this with AOP.
		
	}
}
