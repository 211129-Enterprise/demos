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
		out.write( new ObjectMapper().writeValueAsString(mudButtMan) );
		out.println("Oh noes! Mud Butt Man is on the loose and the session... is set!");
		
		
		
		//// TODO Auto-generated method stub
		////response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capture input from the HTTP request
		String name = request.getParameter("name");
		String superPower = request.getParameter("superpower");
		double bounty = Double.parseDouble( request.getParameter("bounty") );
		
		// 2. Instantiate an object with that info
		SuperVillian vill = new SuperVillian(name, superPower, bounty);
		
		// 3. Grab the HTTP session from the request
		HttpSession session = request.getSession();
		
		// 4. Send the custom vill object to the session
		session.setAttribute("the-villian", vill); // In our HelperSessionServlet, we're capturing the object with the "the-villian" key
													// from the session so we'll set this villian object with the same session.
		
		// 5. Print to the sreen (using Print Writer) that the villian object will successfully send to the session
		PrintWriter out = response.getWriter();
		out.write( new ObjectMapper().writeValueAsString(vill) );
		out.println( "A villian is on the loose... in the session" );
		
		// After it's been sent to the session, you can retrieve it by sending a GET request to the HelperSessionServlet
		
		
		//// TODO Auto-generated method stub
		////doGet(request, response);
	}

}
