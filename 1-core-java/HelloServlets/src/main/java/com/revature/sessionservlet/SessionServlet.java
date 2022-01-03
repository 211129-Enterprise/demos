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
	
	
	// init() method call by the web or servlet container "Tomcat" hits  /dirserv route
	// lazy loading is the default, to enable eager loading it must be initialized in web xml
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		response.setContentType("text/html");
//		
//		PrintWriter out = response.getWriter();
//		
//		out.print("<html><body><h1>The Servlet is talking directly to the client </h1></body></html>");
		
		SuperVillain mudman = new SuperVillain("Mud Man", "mud armor", 400);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("the-villain", mudman);
		// we need to map where this functionality is available
		
		PrintWriter out = response.getWriter();
		
		out.write(new ObjectMapper().writeValueAsString(mudman));
		
	    out.println("mud man is on the loose and the session is set!");
		
	}
	
	
	
	// destroy() is called
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		
		String name = request.getParameter("name");
		
		String superPower = request.getParameter("superpower");
		
		double bounty = Double.parseDouble(request.getParameter("bounty"));
		
		SuperVillain vill = new SuperVillain(name, superPower, bounty);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("the-villain", vill);
		
		PrintWriter out = response.getWriter();
		
		out.write(new ObjectMapper().writeValueAsString(vill));
		
		out.println("A villain is on the loose... (in the session)");
		
	}
	
	// http response has the response header
	// status code
}
