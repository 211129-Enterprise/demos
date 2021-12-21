package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillain;

/**
 * Servlet implementation class HelperSessionServlet
 */
public class HelperSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		SuperVillain vill = (SuperVillain) session.getAttribute("the-villain");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		if (vill != null) {
			out.println("We have captured the villain from the session.");

			out.println("<h1>Villain name: " + vill.getName() + "</h1><br />");
			out.println("<b>SuperPower: " + vill.getSuperPower() + "</b><br />");
			out.println("<i>Bounty: " + vill.getBounty() + "</i><br />");
		} else {
			out.println("<i>Couldn't find any villains.</i>");
		}
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
