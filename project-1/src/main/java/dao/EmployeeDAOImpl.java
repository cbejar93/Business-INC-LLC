package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public List<Employee> employeeAll() {
		// TODO Auto-generated method stub
		List <Employee> emp = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE";
		try {
			try {
				Connection con = ConnectionUtil.getConnection("connection.properties");
				PreparedStatement pstm = con.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					emp.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public Employee getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

}
