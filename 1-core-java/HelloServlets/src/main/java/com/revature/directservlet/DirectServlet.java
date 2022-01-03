package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

public class DirectServlet extends HttpServlet {
	
	
	// init() method call by the web or servlet container "Tomcat" hits  /dirserv route
	// lazy loading is the default, to enable eager loading it must be initialized in web xml
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		System.out.print("<html><body><h1>The Servlet is talking directly to the client </h1></body></html>");
		
		
		// we need to map where this functionality is available
	}
	
	
	
	// destroy() is called
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// transform a java object into JSON and send it to the browser
		
		// step 1. declare the type fo content for our http response
		response.setContentType("application/json");
		
		// step 2 instantiate the object 
		
		SuperVillain vill = new SuperVillain("The Penguin", "money", 900.10);
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		
		
	}
	
	// http response has the response header
	// status code
}
