package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.model.Food;
import com.revature.service.FoodService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
	
	// logger
	private Logger log = LoggerFactory.getLogger(getClass());
	// autowire a FoodService dependency in here
	@Autowired
	FoodService foodServ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Food f1 = new Food("Pasta", 200);
		foodServ.add(f1);
	}

}
