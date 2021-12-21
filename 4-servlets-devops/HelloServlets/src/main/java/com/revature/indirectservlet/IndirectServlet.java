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
public class IndirectServlet extends HttpServlet { // HttpServlet extends GenericServlet implements Servlet interface
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * If we GET a request is sent here, we re-direct to the dirservlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("http://localhost:8080/HelloServlets/dirserv");
		//response.sendRedirect("http://google.com"); // You can re-direct to another site too.
		System.out.println("Triggered the doGet() method of IndirectServ");
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * The purpose of the POST request is to show what happens with the forward() method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// We also have "forward()" which is fetched from the RequestDispatcher which further processes the original
		// request rather than generating a new one.
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		rdis.forward(request, response);
		System.out.println("Triggered the doPost() method of IndirectServ");
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
