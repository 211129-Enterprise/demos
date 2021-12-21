package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillian;

/**
 * Servlet implementation class HelperSessionServlet
 */
public class HelperSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelperSessionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// When we invoke the doGet method on this servlet, it will return the
		// Villian object that has been saved to the session.
		
		// Grab the session from the request
		HttpSession session = request.getSession();
		
		// Save the object to a fetched from the session to a SuperVillian object.
		SuperVillian vill = (SuperVillian) session.getAttribute("the-villian"); // We are seraching for the object that we bound to
																// the session based on the attribute that we set in
																// the SessionServlet's doGet() method.
		
		
		// After "Capturing" the villian info from the session, print it out via the print writer.
		PrintWriter out = response.getWriter();
		
		// Let's generate an HTML page on the fly!
		out.println("<html><body>");
		
		if(vill != null) {
			out.println("<h1>We've captured the villian from the session!</h1>");
			
			// Print out the HTML with all the properties of the villian we captured
			out.println( "<b>Villian Name:</b> " + vill.getName() + "<br/>" );
			out.println( "<b>Villian Superpower:</b> " + vill.getSuperPower() + "<br/>" );
			out.println( "<b>Villian Bounty:</b> $" + vill.getBounty() + "<br/>" );
		} else {
			out.println("<i>We couldn't find any villians</i> :-(");
		}
		
		out.println("</body></html>");
		
		//// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
