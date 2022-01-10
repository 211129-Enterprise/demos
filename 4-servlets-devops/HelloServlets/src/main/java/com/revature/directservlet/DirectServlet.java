package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

public class DirectServlet extends HttpServlet { 

	/** When a client sends a GET request to the server at some location (which we have yet to map...this will be
	 * done in our Deployment Descriptor - web.xml), it will trigger this method.
	 */
	
	// init() is called 
	
	public static void main(String[] args) {
		
	}
	
	public static int[] solution(int[] data, int n) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		for(int i : data) {
			a.add(i);
		}
		
		return Arrays.stream(data).filter(m -> (Collections.frequency(a, m) <=n)).toArray();
	}
	
	
	
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
		
		
		// Call the Servlet context!
		System.out.println("Context Example: " + getServletContext().getInitParameter("contextExample"));
		
		// You could make a log statement here logging what servlet is handling the get request
		System.out.println("Config Example: " + getServletConfig().getInitParameter("configExample"));
		
	}
	
	/**
	 * This method is responsible for handling a POST request that a client sends.
	 * Instantiate an object, and send back the object's data in the form of JSON - JavaScript Object Notation
	 * JSON = a data interchange format
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		// Step 1. Declare the type of content for our HTTP response
		response.setContentType("application/json");
		
		// Step 2. Instantiate an object
		SuperVillain vill = new SuperVillain("The Penguin", "money", 900.10);
		
		// transform a java object into JSON and send it to the browser (client) in the body of the HTTP response
		// Here we're both transforming is AND sending it via the print writer on the response
		response.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		// import ObjectMapper from Jackson Databind
	}
	
	/**
	 * HTTP Response
	 * 
	 * Response Header
	 * 	- HTTP Version
	 * 	- Status code
	 * 
	 * Response Body (contains the data its sending back!)
	 */
	
	
	
	// destroy() is called
}
















