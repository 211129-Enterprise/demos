package com.revature.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {
	
	// Below we feature 3 beans, each with credentials for different types of environments
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean
	public String devDBConnection() {
		System.out.println("DB Connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection for DEV - H2";
	}
	
	@Profile("test")
	@Bean
	public String testDBConnection() {
		System.out.println("DB Connection for TEST - Low Cost RDS Instance");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection for TEST - Low Cost RDS Instance";
	}
	
	@Profile("prod")
	@Bean
	public String prodDBConnection() {
		System.out.println("DB Connection for PROD - High Performance RDS Instance");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection for PROD - High Performance RDS Instance";
	}

}
