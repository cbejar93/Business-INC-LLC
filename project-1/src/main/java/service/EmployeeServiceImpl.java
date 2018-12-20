package service;

import java.util.List;

import beans.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO emp = new EmployeeDAOImpl();

	@Override
	public List<Employee> employeeAll() {
		// TODO Auto-generated method stub
		
		
		return emp.employeeAll();
	}

}
