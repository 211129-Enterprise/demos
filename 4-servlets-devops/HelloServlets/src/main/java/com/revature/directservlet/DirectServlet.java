package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		// Now we need to map where this functionality is available
	}

	
	
}
