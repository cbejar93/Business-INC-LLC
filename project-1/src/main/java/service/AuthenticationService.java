package service;

import beans.Credentials;
import beans.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import java.util.List;

public class AuthenticationService {

	public AuthenticationService() {
	}
	
	public Employee isValidUser(Credentials credentials) {
		Employee e = null;
		EmployeeDAO ed = new  EmployeeDAOImpl();

		String username = credentials.getEmail();
		String password = credentials.getPassword();
		//this is AUTHENTICATION (does the user exist in the system?)
		//now AUTHORIZATION (what can the user access within the system?) (user roles)
		//take credentials and return the User to which they belong if it exists
		System.out.println(username);
		System.out.println(password);
		List<Employee> emps = ed.employeeAll();

		if (username != null && password != null) {
			for (Employee e1: emps) {
				if (username.equals(e1.getEmail()) && password.equals(e1.getPassword())) {
//					e = new Employee(5,username,"Merlin","Cat","wizcat@tampa.com");
							e=e1;
				}
				
			}
			
		}
		return e;
	}
	
}
