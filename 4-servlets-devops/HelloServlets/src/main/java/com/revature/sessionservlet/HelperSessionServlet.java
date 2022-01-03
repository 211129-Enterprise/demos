package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillain;

public class HelperSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// When we invoke the doGet() method on this Servlet, it will return the Villain Object 
		// that has been saved to the session
		
		// Grab the session from the target
		HttpSession session = request.getSession();
		
		// save the object to a SuperVillain type
		SuperVillain vill = (SuperVillain) session.getAttribute("the-villain"); // search for the object that we bound to
		// the session based on the attribute we set in the SessionServlet's doGet() method.
		
		// after capturing the villain info from the session, print it out via printwriter
		PrintWriter out = response.getWriter();
		
		// Let's generate an HTML page on the fly!
		out.println("<html><body>");

		if (vill != null) {
			out.println("We have captured the villain from the session!");
			// print out the HTML with all of the properties of the villain we captured
			out.println("<h1>Villain name: " + vill.getName() + "</h1><br />");
			out.println("<b>SuperPower: " + vill.getSuperpower() + "</b><br />");
			out.println("<i>Bounty: $" + vill.getBounty() + "</i><br />");
		} else {
			out.println("<i>Couldn't find any Villains</i>");
		}
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
