package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static final Logger log = Logger.getLogger(App.class);
	
	private static final String CONFIG_LOCATION = "beans.xml";
	
	public static void main(String[] args) {
		// The spring IoC Container will manage dependcy injection for us
		
		// Step 1. Create the Context (Application Context)
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
										
		// Step 2
		NumberGenerator numberGen = context.getBean("myNumGenerator", NumberGenerator.class);
		
//		NumberGenerator numberGen = context.getBean(NumberGenerator.class);
		
		Game game = context.getBean(Game.class);
		
		
		
		// Step 3. Call next() (since the bean is fully assembled with its dependency
		int number = numberGen.next();
		
//		System.out.println("the number is " + number);
		log.info("the number is " + number);	
		
		game.reset();
		
		number = game.getNumber();
		
		log.info("the number is " + number);
		context.close();
		
	}

}
