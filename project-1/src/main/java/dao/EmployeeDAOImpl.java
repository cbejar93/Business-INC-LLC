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
		List<Employee> emp = new ArrayList<>();
		String sql = "SELECT * FROM EMPLOYEE";
		try {
			try {
				Connection con = ConnectionUtil.getConnection("connection.properties");
				PreparedStatement pstm = con.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					emp.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5)));
				}
				con.close();
				rs.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	public Employee getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		Employee emp = null;
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");

			PreparedStatement ptsm = con.prepareStatement(sql);
			ptsm.setInt(1, id);

			ResultSet rs = ptsm.executeQuery();

			while (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			System.out.println(emp);
			con.close();
			rs.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	public void createEmployee(Employee e) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO EMPLOYEE (PASSWORD, FIRSTNAME, LASTNAME, EMAIL) \r\n" + "VALUES (?,?,?,?) ";
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, e.getPassword());
			psmt.setString(2, e.getFirstName());
			psmt.setString(3, e.getLastName());
			psmt.setString(4, e.getEmail());
			psmt.executeUpdate();
			con.close();
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			PreparedStatement ppmt = con.prepareStatement(sql);
			ppmt.setInt(1, id);
			ppmt.executeUpdate();
			con.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		String sql = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME=?, EMAIL=? WHERE EMPLOYEE_ID = ?";

		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, e.getFirstName());
			psmt.setString(2, e.getLastName());
			psmt.setString(3, e.getEmail());
			psmt.setInt(4, e.getEmployeeID());
			psmt.executeUpdate();
			con.close();
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
