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

	/*
	 * When a client sends a GET request to a server at some location (which we have yet to map... this will be
	 * done in our Deployment Descriptor - web.xml), it will trigger this method.
	 */
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//Here we can deliver a response!
		//Lets send back a raw HTML that says "the server is talking directly to the client."
		response.setContentType("text/html");
		
		/*
		 * PrintWriter is an object that prints text data to a character stream which we call on the response object.
		 */
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>The servlet is talking directly to the client!</h1></body></html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("application/json");
		
		SuperVillain vill = new SuperVillain("The Penguin", "money", 900.10);
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		
		
	}
	
	
}
