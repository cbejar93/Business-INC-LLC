package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Credentials;
import beans.Employee;
import service.AuthenticationService;


public class LandingServlet extends HttpServlet {
	
	AuthenticationService authService = new AuthenticationService();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("client/landing.html");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("handling request...");
		// checks whether a session exists, otherwise creates a new one. 
		// overloaded version takes a boolean create param, if false it returns 
		// null if no session exists for the current request. 
		HttpSession session = req.getSession(); 
		resp.setContentType("text/html");
		//grab params from request 
		Credentials cred = new Credentials(req.getParameter("username"),req.getParameter("password"));
		//attempt to authenticate the user
		Employee e = authService.isValidUser(cred);
		//set user information as session attributes
		if (e != null) {
			session.setAttribute("eId", e.getEmployeeID());
			session.setAttribute("firstname", e.getFirstName());
			session.setAttribute("lastname", e.getLastName());
			session.setAttribute("email", e.getEmail());
			session.setAttribute("problem", null);
			//redirect user to profile page if authenticated
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "invalid credentials");
			//redirect user to login page if authentication fails
			resp.sendRedirect("login");
		}
	}

}
