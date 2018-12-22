package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import service.IdTokenVerifierAndParser;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  resp.setContentType("text/html");

	        try {
	            String idToken = req.getParameter("id_token");
	            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
	            String name = (String) payLoad.get("name");
	            String email = payLoad.getEmail();
	            System.out.println("User name: " + name);
	            System.out.println("User email: " + email);

	            HttpSession session = req.getSession(true);
	            session.setAttribute("userName", name);
	            req.getServletContext()
	               .getRequestDispatcher("/welcome-page.jsp").forward(req, resp);

	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	}


