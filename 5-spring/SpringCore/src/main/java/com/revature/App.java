package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	// == Constants ==
	private static final Logger log = LoggerFactory.getLogger(App.class);
	private static final String CONFIG_LOCATION = "beans.xml";
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// The Spring IoC container will manage dependency injection for us
		
		// Step 1. Create the Context (Application Context) by feeding it configuration details!
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION); // This reads from a config file
		// Bean wiring lives at that location
		
		
		// Step 2. Instantiate a NumberGenerator Bean using Spring IoC
		NumberGenerator numberGen = context.getBean("myNumGenerator", NumberGenerator.class); // This points to the interface
																							// that the impl class implements
		
		// Step 3. Call the next() method (Since the bean is fully assembled with its dependency)
		int number = numberGen.next();
		System.out.println("The number is: " + number);
		
		context.close(); // Prevent memory leakage

	}

}
