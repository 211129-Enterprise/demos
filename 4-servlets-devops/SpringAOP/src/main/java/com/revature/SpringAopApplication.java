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

	//logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//autowire business 1
	@Autowired
	private Business1 business1;
	
	//autowire business 2
	@Autowired
	private Business2 business2;
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringAopApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info(business1.calculateSomething());
		log.info(business2.calculateSomething());
		
	}

	// run(); ....
}
