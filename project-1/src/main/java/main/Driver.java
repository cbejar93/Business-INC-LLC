package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import beans.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import util.ConnectionUtil;

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
		
		EmployeeDAO ed = new  EmployeeDAOImpl();
		List<Employee> emps = ed.employeeAll();
		for (Employee e: emps) {
			System.out.println(e);
		}
		ed.getEmployeeByID(2);
//		Employee ed2 = new Employee(3,"Max","Couch","mcouch91@gmail.com");
//		ed.createEmployee(ed2);
		ed.deleteEmployee(3);

	}
	

	

}


