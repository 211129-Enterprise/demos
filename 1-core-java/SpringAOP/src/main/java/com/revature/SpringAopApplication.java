package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.business.Business1;
import com.revature.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private Business1 business1;
	
	private Business2  business2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info(business1.calculateSomething());
		log.info(business2.calculateSomething());
	}

}
