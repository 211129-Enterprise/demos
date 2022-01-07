package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
<<<<<<< HEAD

public class App {

//	== constants ==
	private static final Logger Log = LoggerFactory.getLogger(App.class);
	private static final String CONFIG_LOCATION = "beans.xml";
	
	
	public static void main(String[] args) {
		
		// The Spring IoC Container will manage dependency injection for us
		
		// Step 1. Create the Context (Application Context)
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION); // this reads from a config file
		// Bean wiring lives at that location
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // this reads from a config file

		
		// Step 2. Instantiate a NumberGenerator Bean using Spring IoC
		NumberGenerator numGen = context.getBean("myNumGen", NumberGenerator.class); /* this points to the interface
																					  	that the impl class implements */
		Game game = context.getBean(Game.class);
		
		// Step 3. Call next() (since the bean is fully assembled with its dependency
		int number = numGen.next();
		
//		System.out.println("The number is: " + number);
		Log.info("The number is {}", number);
		
		game.reset();
		
		number = game.getNumber();
		
		Log.info("The number is {}", number);
		
		
		
		context.close(); // prevent memory leakage

=======
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(App.class);
	private static final String CONFIG_LOCAION = "beans.xml";
	
	public static void main(String[] args) {
		// The Spring IoC Container will manage Dependecy injection for us
		
		// Step 1. Create the Context (Application Context) by feeding it configuration details!
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCAION); // this reads from a config file
		// Bean wiring lives at that location
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
		
		
		// Step 2. Instantiate a NumberGenerator Bean using Spring IoC
		NumberGenerator numberGen = context.getBean("myNumGenerator", NumberGenerator.class); // this points to the bean object that implements the interface	
		Game game = context.getBean(Game.class); 
		
		// Step 3. Call next() (since the bean is fully assembled with its dependency
		int number = numberGen.next();
		
//		System.out.println("The number is: " + number);
		log.info("The number is {}", number);
		
		game.reset(); // this will print out the number
		
		number = game.getNumber(); // fetches the new number generated after the reset
		
		log.info("The number is {}", number);
		
		MessageGenerator msg = context.getBean(MessageGenerator.class);
		
		log.info("getMainMessage = {}", msg.getMainMessage());
		

		context.close(); // prevent memory leakage
>>>>>>> main
	}

}
