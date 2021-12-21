package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillian;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * When we send a GET request to this servlet, at seserv url, we will send a Villian
	 * object to the session
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Hard code a villian object
		SuperVillian mudButtMan = new SuperVillian("Mud Butt Man", "MUD", 419);
		
		// Capture the HTTP session from the request object
		HttpSession session = request.getSession();
		
		// Save the villian object to the session
		session.setAttribute("the-villian", mudButtMan);
		
		// Use the print writer from the response object to print out some message
		// to the browser about what happened.
		PrintWriter out = response.getWriter();
		
		// Write it out in JSON format
		out.write(new ObjectMapper().writeValueAsString(mudButtMan));
		out.println("Oh noes! Mud Butt Man is on the loose and the session... is set!");
		
		
		
		//// TODO Auto-generated method stub
		////response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//// TODO Auto-generated method stub
		////doGet(request, response);
	}

}
