package com.revature.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Configuration
public class RootController {

	@GetMapping("/docs") // find all Swagger API docs at http://host:5000/api/docs
	@ResponseStatus(HttpStatus.SEE_OTHER)
	public RedirectView redirectViewToApiDocumentation() {
		return new RedirectView("swagger-ui/index.html");
	}
	
	
}
