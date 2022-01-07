package com.revature.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

	// Below we feature 3 beans, each with credentials for different types of environemnts
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Profile("dev")
	@Bean
	public String devDBConnection() {
		System.out.println("DB connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection for DEV - H2";
	}
	
	@Profile("test")
	@Bean
	public String testDBConnection() {
		System.out.println("DB connection for TEST - Low Cost RDS instance");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection for TEST - Low Cost RDS instance";
	}
	
	@Profile("prod")
	@Bean
	public String prodDBConnection() {
		System.out.println("DB connection for PROD - High Performance RDS instance");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection for PROD - High Performance RDS instance";
	}
	
	
	
}
