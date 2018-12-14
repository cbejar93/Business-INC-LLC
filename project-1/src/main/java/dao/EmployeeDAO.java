package dao;

import java.util.List;

import beans.Employee;

public interface EmployeeDAO {

	
	public List<Employee> employeeAll();
	public Employee getEmployeeByID(int id);
	public void createEmployee(Employee e);
	public void deleteEmployee(int id);
	public void updateEmployee(Employee e);
			
}
