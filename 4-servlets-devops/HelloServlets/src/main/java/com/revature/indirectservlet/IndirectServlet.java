package com.revature.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndirectServlet
 */
public class IndirectServlet extends HttpServlet { // HttpServlet extends GenricServlet implements Servlet Interface
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * If a GET request is sent here we re-direct to the dirservlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// redirecting the user to another resource on our server
		// When you use sendRedirect, a new request is created which re-writes the URL 9
//		response.sendRedirect("http://localhost:8080/HelloServlets/dirserv");
		response.sendRedirect("https://google.com");
		
		System.out.println("Triggered the doGet() method of IndirectServ");
	}

	/**
	 * The purpose of the post request is to show what happens with the forward() method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward() which is fetched from the RequestDispatcher which further processes the original
		// request rather than generating a new one
		
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		rdis.forward(request, response);
		
		System.out.println("doPost() method triggered");

	}
	
	/*
	 * Here is a list of major differences between servlet forward and
	 * sendRedirect()
	 * 
	 * sendRedirect():
	 * 
	 * The request is redirected to a different resource The client will see the URL
	 * change after the redirect A totally new request is created Redirect is
	 * normally used within Post/Redirect/Get web development pattern
	 *
	 * 
	 * forward():
	 * 
	 * The request will be further processed on the server side The client isn't
	 * impacted by forward, URL in a browser stays the same Request and response
	 * objects will remain the same object after forwarding. Request-scope objects
	 * will be still available
	 */


	
	
	
	
	
	
	
	
	
	
	
}
