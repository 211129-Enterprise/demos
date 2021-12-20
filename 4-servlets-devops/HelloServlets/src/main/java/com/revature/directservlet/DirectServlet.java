package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DirectServlet extends HttpServlet {

	/** When a client sends a GET request to the server at some location (which we have yet to map...this will be
	 * done in our Deployment Descriptor - web.xml), it will trigger this method.
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// here we can deliver a response!
		// let's send back raw HTML that says "the server is talking directly to the client!"
		response.setContentType("text/html");
		
		/*
		 * PrintWriter is an object that prints text data to a character stream which we call on the reponse object
		 */
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>The Servlet is talking directly to the client!</h1></body></html>");

		// Now we need to map where this functionality is available
	}
}
