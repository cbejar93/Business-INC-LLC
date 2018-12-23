package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;

/**
 * Servlet implementation class Session
 */
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("eId") != null) {
			try {
//				System.out.println("hello from session servlet"+session.getAttribute("eId"));
				int userId = Integer.parseInt(session.getAttribute("eId").toString());
//				String username = session.getAttribute("username").toString();
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String email = session.getAttribute("email").toString();
				System.out.println(userId);
				Employee e = new Employee(userId, firstname, lastname, email);
				System.out.println(e);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
