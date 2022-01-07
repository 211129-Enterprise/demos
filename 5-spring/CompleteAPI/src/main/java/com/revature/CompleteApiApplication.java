package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class CompleteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompleteApiApplication.class, args);
	}
	
	@RequestMapping("/")
	public ModelAndView home()
	{
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}

}
