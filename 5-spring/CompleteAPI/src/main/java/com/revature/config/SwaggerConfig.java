package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	
	/*
	 * Made possible by the SpringFox dependency
	 * https://www.webdevelopmenthelp.net/2016/08/use-spring-fox-java-application-development.html
	 */
	// Expose endpoints at :5000/api/swagger-ui
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.revature.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
}
