package com.revature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
<<<<<<< HEAD
 * This is programatic configuration of the Application Context
 * We ened to use Annotations to configure our beans and dependencies
 * 
 * This class is a replacement for the XML configuration
=======
 * This is programatic configuration of the Application Context.
 * We need to use Annotations to configure this our beans & dependencies
 * 
 * This class is a replacement for XML configuration
>>>>>>> main
 */

@Configuration
@ComponentScan(basePackages = "com.revature")
public class AppConfig {
	
	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGeneratorImpl();  // This can be injected into another class
	}
	
	@Bean
	public Game game() {
		return new GameImpl(); /* Because the numberGenerator property in the GameImpl is @Autowired
								  Spring IoC container knows that we need to inject a NumberGeneratorImpl into it */
	}
	
	@Bean
	public MessageGenerator messageGenerator() {
		return new MessageGeneratorImpl();
	}
	
}	
