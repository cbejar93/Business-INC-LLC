package service;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private static final long serialVersionUID =1L;
	private ObjectMapper om = new ObjectMapper();
	
	private EmployeeDAO emp = new EmployeeDAOImpl();

	@Override
	public List<Employee> employeeAll() {
		// TODO Auto-generated method stub
		
		
		return emp.employeeAll();
	}

}
