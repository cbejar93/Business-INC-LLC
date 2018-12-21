package main;

import java.util.List;

import beans.Employee;
import beans.Reimbursment;
import dao.ReimbursmentDAO;
import dao.ReimbursmentDAOImpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 final String filename = "connection.properties";
//		 try {
//			Connection con = ConnectionUtil.getConnection(filename);
//			System.out.println(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		EmployeeDAO ed = new  EmployeeDAOImpl();
//		List<Employee> emps = ed.employeeAll();
//		for (Employee e: emps) {
//			System.out.println(e);
//		}
//		ed.getEmployeeByID(2);
//		Employee ed2 = new Employee(3,"Max","Couch","mcouch91@gmail.com");
//		ed.createEmployee(ed2);
//		ed.deleteEmployee(3);
//		Employee ed3 = new Employee(3,4,"Timmy","Couch","mcouch91@gmail.com");
//		ed.updateEmployee(ed3);
		ReimbursmentDAO rmb = new  ReimbursmentDAOImpl();
		List<Reimbursment> reims = rmb.ReimbursmentAll();
		for (Reimbursment r: reims) {
			System.out.println(r);
		}
		rmb.getReimbursmentByID(2);
		Reimbursment rm1 = new Reimbursment("plates", 290, 4, 1,"APPROVED", "10/14/17", "EDDY");
		rmb.createReimbursment(rm1);
		rmb.deleteReimbursment(4);


	}
	

	

}


