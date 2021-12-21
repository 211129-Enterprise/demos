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
    * When we send a GET request this servlet, (at /sesserv url) we will a Villain Object to the session
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Hard code a villain object
		SuperVillain mudman = new SuperVillain("Mud Man", "mud armor", 400);
		
		// Capture the HTTP session from the request object
		HttpSession session = request.getSession();
		
		// Save the villain object to the session
		session.setAttribute("the-villain", mudman);
		
		session.getId();
		
		// Use the print writer fromthe response object to print out some message to the browser about what happened
		PrintWriter out = response.getWriter();
		// write it out in JSON format!
		out.write(new ObjectMapper().writeValueAsString(mudman));
		out.println("Mud man is on the loose and the session is set!");
		
		
	}

	/**
	 * The purpose of this method is to capture the parameters from the HTTP Request that is sent to the /sesserv
	 * URL, then instnatiate an object from them and add it to the session.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Capture input from the HTTP request
		String name = request.getParameter("name"); // this must match with the name of the input field in index.html
		String superPower = request.getParameter("superpower");
		double bounty = Double.parseDouble(request.getParameter("bounty")); // convert a String to double by parsing
		
		// 2. Instantiate an object with that info
		SuperVillain vill = new SuperVillain(name, superPower, bounty);
		
		
		// 3. Grab the HTTP Session from the request
		HttpSession session = request.getSession();
		
		// 4. Send the custom vill object to the session
		session.setAttribute("the-villain", vill); // in our HelperSessionServlet we are capturing the object with the "the-villain"
		// key from the session, so we'll set this villain object with the same session
		
		// 5. Print to the screen (using Print Writer) that the villain object was successfully sent to the session 
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(vill));
		out.println("A villain is on the loose...(in the session)");
		
		// After it's been set to the session, you can retrieve it by sending a GET request to the HelperSessionServlet
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
