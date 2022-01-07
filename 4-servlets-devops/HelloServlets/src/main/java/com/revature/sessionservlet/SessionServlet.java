package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;


public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * When we send a GET request to this servlet, (at /sesserv url) we will save a Villain Object to the session
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Hard code a villain object
		SuperVillain mudman = new SuperVillain("Mudman", "Muddy boots", 400);
		
		// Capture the HTTP session from the request object
		HttpSession session = request.getSession();
		
		// Save the villain object to the session
		session.setAttribute("the-villain", mudman);
		
		// Use the printwriter from the response object to print out some message to the browser
		PrintWriter out = response.getWriter();
		// write it out in JSON format
		out.write(new ObjectMapper().writeValueAsString(mudman));
		out.println("Mudman is on the loose and the session is set!");
		
	}

	/**
	 * The purpose of this method is to capture the parameters form the HTTP request that is sent to the /sesserv
	 * URL, then instantiate an object from them and add it to the session
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Capture input from the HTTP Request
		String name = request.getParameter("name"); // this has to match the name of the input field
		String superPower = request.getParameter("superpower");
		double bounty = Double.parseDouble(request.getParameter("bounty"));
		
		// 2. Instantiate an object with that info
		SuperVillain vill = new SuperVillain(name, superPower, bounty);
		

		// 3. Grab the HTTP Session from the request
		HttpSession session = request.getSession();
		
		// 4. Send the custom vill object to the session

		session.setAttribute("the-villain", vill); // in our HelperSessionServlet we are capturing the object with "the-vill"
		// key from the session, so we'll set this villain object with the same session
		
		// 5. Print to the screen that the villain object was successfully sent to he session
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(vill));
		out.println("A villain is on the loose... in the session");
		
		// After it's been set to the session, you can retrieve it by sending a GET request to the HelperSessionServlet
	}


}
