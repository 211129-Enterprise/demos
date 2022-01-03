package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(App.class);
	private static final String CONFIG_LOCAION = "beans.xml";
	
	
	
	
	public static void main(String[] args) {
	
		// The Spring IoC Container will manage Dependecy injection for us
		
		// Step 1. Create the Context (Application Context) by feeding it configuration details!
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCAION); // this reads from a config file
		// Bean wiring lives at that location
		
		
		// Step 2. Instantiate a NumberGenerator Bean using Spring IoC
		NumberGenerator numberGen = context.getBean("myNumbersjdgklsdjGenerator", NumberGenerator.class); // this points to the interface	
																							  // that the impl class implements
		// Step 3. Call next() (since the bean is fully assembled with its dependency
		int number = numberGen.next();
		
//		System.out.println("The number is: " + number);
		log.info("The number is {}", number);
		
		context.close(); // prevent memory leakage
		
		

	}

}
