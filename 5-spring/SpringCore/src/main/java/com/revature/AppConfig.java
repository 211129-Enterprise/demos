package com.revature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This is programmatic configuration of the application context
// We need to use Annotations to configure our beans and dependencies
//
// This class is a replacement for XML configuration
@Configuration
@ComponentScan(basePackages = "com.revature")
public class AppConfig {

	@Bean
	public NumberGenerator numberGenerator() {	// Component
		return new NumberGeneratorImpl();	// This CAN be injected into another class because it's annotated with @Component
	}
	
	
	@Bean
	public Game game() { // Autowired
		
		return new GameImpl(); // Because the numberGenerator property in the
								// GameImpl is @Autowired, Spring IoC container
								// knows that we need to inject a NumberGeneratorImpl
								// into it.
	}
	
	
	@Bean 
	public MessageGenerator messageGenerator() {
		return new MessageGeneratorImpl();
	}
	
}
