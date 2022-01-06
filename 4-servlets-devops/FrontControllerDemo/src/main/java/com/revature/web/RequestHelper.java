package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class RequestHelper {
	
	// a logger
	private static Logger logger = Logger.getLogger(RequestHelper.class);
	// an employeeService instance
	private static EmployeeService eserv = new EmployeeService(new EmployeeDAO());
	// an object mapper
	private static ObjectMapper om = new ObjectMapper(); // this is from Jackson Data Bind library
	
	
	public static void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		// extract the parameters from the HttpServlerRequest (username & password)
		// We're reading the username and password parameter values
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		logger.info("User attempted to login with username " + username);
		
		// call the confirmLogin() method with those values
		Employee e = eserv.confirmLogin(username, password);
		
		// IF the user is not null, save the user to the session, and print the user's info to the client using print writer
		if (e != null ) {
			
			// grab the sessiona dn add the user to it
			HttpSession session = request.getSession();
			session.setAttribute("the-user", e); // binding the retrieved user object to the session and giving it the key "the-user"
			
			// print the logged in user to the screen
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			// conver the object with Jackson object mapper and print it out
			out.println(om.writeValueAsString(e));
		} else {
			// if the reutrned object is null return a HTTP status called No Content Status
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("No user found, sorry");
			response.setStatus(204); 
		}
	}
	
	public static void processEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		// 1. set the content type of the response
		response.setContentType("text/html");
		
		// 2. Call the findAll() method from the Service layer and save it a list
		List<Employee> allEmployees = eserv.findAll(); // this calls our DAO layer, which retrieves all objects from the DB
		
		// 3. Marshall the list of Java Objects to JSON (using Jackson as our Object Mapper)
		String jsonString = om.writeValueAsString(allEmployees);
		
		// 4. Call the Print Writer to write it out to the client (browser) in the response body
		PrintWriter out = response.getWriter();
		out.println(jsonString);
	}
	
	
	public static void processError(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	// If something goes wrong, redirect the user to a custom 404 page 
		request.getRequestDispatcher("error.html").forward(request, response);
		/**
		 * forward() differs from sendRedirect() in that it DOES NOT produce a new request, but rather
		 * just forwards the same request to a new resource(maintaining the URL).
		 */
		
	}
	

}
