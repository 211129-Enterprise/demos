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
public class MySpringDataJpaApplication implements CommandLineRunner {
	
	// add a logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// autowire a foodService dependency in here 
	@Autowired
	FoodService foodServ;
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Food f1 = new Food("pasta", 200);
		foodServ.add(f1);
		
		
	}

}
