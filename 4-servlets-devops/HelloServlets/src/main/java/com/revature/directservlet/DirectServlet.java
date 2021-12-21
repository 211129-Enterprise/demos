package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillian;

public class DirectServlet extends HttpServlet{
	
	
	/* When the client sends a GET request to the server at some location, 
	 * which we have yet to map... this will be done in our deployment descriptor - 
	 * web.xml), it will trigger this method.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		// Here we can deliver a response!
		// Let's send back RAW HTML that says "The server is talking directly to the client!"
		response.setContentType("text/html");
		
		
		/*
		 * PrintWriter
		 * An object that prints text data to a character stream which
		 * we can call on the response object.
		 */
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Generic Response</title></head><body style='background: #1B2634;'><h1 style='color:#FFF; font-family: Helvetica;'>The server is talking directly to the client!</h1></body></html>");
		
		// ...now we need to map where this functionality is available
	}
	
	
	
		/*
		 * This method is responsible for handling a POST request that a client sends.
		 * Instantiate an object and send back the object's data in the form of JSON,
		 * JavaScript Object Notation, which is a data interchange format.
		 */
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
			
			// Step 1. Declare the type of content for our HTTP response
			response.setContentType("application/json");
			
			// Step 2. Instantiate an object
			SuperVillian vill = new SuperVillian("The Penguin", "money", 900.10);
			
			// Transform a java object into JSON and send it to the browser
			response.getWriter().write( new ObjectMapper().writeValueAsString(vill) );
		}
	
		/*
		 * HTTP RESPONSE HAS:
		 *  + Response Header
		 *  	> HTTP Version
		 *  	> Status Code
		 *  
		 *  + Response Body
		 *  	> Content / Data
		 */

	
	
}
