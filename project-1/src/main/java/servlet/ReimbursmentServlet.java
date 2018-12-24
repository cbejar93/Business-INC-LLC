package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import service.ReimbursmentService;
import service.ReimbursmentServiceImpl;

/**
 * Servlet implementation class ReimbursmentServlet
 */
public class ReimbursmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ObjectMapper om;
	private ReimbursmentService reimbursmentService;
	
	
    public ReimbursmentServlet() {
    	reimbursmentService = new ReimbursmentServiceImpl();
		om = new ObjectMapper();
//		om.registerModule(new Module());
		om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getRequestURI()) {
				case "/project-1/reimbursment":
					System.out.println(request.getRequestURI());
					int eid = Integer.parseInt(request.getParameter("eid"));
					response.getWriter().write(om.writeValueAsString(reimbursmentService.getReimbursmentByEmployeeId(eid)));
					break;
				case "/project-1/reimbursments":
					response.getWriter().write(om.writeValueAsString(reimbursmentService.ReimbursmentAll()));
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
