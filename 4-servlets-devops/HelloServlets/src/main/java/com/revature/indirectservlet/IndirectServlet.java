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
public class IndirectServlet extends HttpServlet { //HttpServlet extends GenericServlet implements Servlet Interface
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * IF a GET request is sent here, we redirect to the dirserv
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// redirecting the user to another resource on our server
		// When you use sendRedirect, a new request is created which re-writes the URL
//		response.sendRedirect("http://localhost:8080/HelloServlets/dirserv");
		response.sendRedirect("https://google.com");		
		System.out.println("Triggered the doGet() method of IndirectServlet");
		
		// Call the servlet context!
		
		System.out.println("Context Example: " + getServletContext().getInitParameter("contextExample"));
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// forward() which is fetched from the RequestDispatcher which further processes the original
		// request rather than generating a new one
		
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		rdis.forward(request, response);
		
		System.out.println("Triggered the doPost() method of Indirect Servlet");
	}

}
