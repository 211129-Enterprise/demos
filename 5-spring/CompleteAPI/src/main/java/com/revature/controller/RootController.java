package com.revature.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

/*
 * This RootController dictates what view will be displayed upon start up
 * You can find this view after running the app > go to http://localhost:5000/api/docs
 */

@Controller
public class RootController {
	
	@GetMapping("/docs") // find all Swagger API docs at http://host:5000/api/docs
	@ResponseStatus(HttpStatus.SEE_OTHER)
	public RedirectView redirectViewToApiDocumentation() {
		return new RedirectView("swagger-ui/index.html");
	}
	
	
	/**
	 * This RootController is necessary along with SwaggerConfig.java
	 */

}
