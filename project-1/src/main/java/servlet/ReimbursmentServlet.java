package servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import beans.Reimbursment;
import dao.ReimbursmentDAO;
import dao.ReimbursmentDAOImpl;
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
//					System.out.println(request.getRequestURI());
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
		System.out.println("this is the doPost");
		String dsc = request.getParameter("eID");
		System.out.println(dsc);
//		StringBuilder sb = new StringBuilder();
//	    BufferedReader reader = request.getReader();
//	    try {
//	        String line;
//	        while ((line = reader.readLine()) != null) {
//	            sb.append(line).append('\n');
//	        }
//	    } finally {
//	        reader.close();
//	    }
//	    System.out.println(sb.toString());
		ReimbursmentDAO rmb = new ReimbursmentDAOImpl();

	    ObjectMapper mapper = new ObjectMapper();
	    Reimbursment riem = mapper.readValue(request.getInputStream(),Reimbursment.class);
	    rmb.createReimbursment(riem);
	    System.out.println(riem);
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
