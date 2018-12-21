package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import beans.Reimbursment;
import util.ConnectionUtil;

public class ReimbursmentDAOImpl implements ReimbursmentDAO {

	@Override
	public List<Reimbursment> ReimbursmentAll() {
		List<Reimbursment> riem = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT";
		try {
			try {
				Connection con = ConnectionUtil.getConnection("connection.properties");
				PreparedStatement pstm = con.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					riem.add(new Reimbursment(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6),rs.getString(7), rs.getString(8)));
				}
				con.close();
				rs.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return riem;
	}	
	

	@Override
	public Reimbursment getReimbursmentByID(int id) {
		Reimbursment rm = null;
		String sql = "SELECT * FROM REIMBURSEMENT WHERE R_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");

			PreparedStatement ptsm = con.prepareStatement(sql);
			ptsm.setInt(1, id);

			ResultSet rs = ptsm.executeQuery();
			
			while(rs.next()) {
				rm =new Reimbursment(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6),rs.getString(7), rs.getString(8));
			}
			System.out.println(rm);
			con.close();
			rs.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rm;
	}

	@Override
	public void createReimbursment(Reimbursment r) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO REIMBURSEMENT (R_DESCRIPTION, AMOUNT, PICTURE_ID, EMPLOYEE_ID, RESOLVED, TIME_RES, WHO_RES) \r\n" + 
				"VALUES (?,?,?,?,?,?,?) ";
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, r.getDescription());
			psmt.setInt(2, r.getAmount());
			psmt.setInt(3, r.getPictureID());
			psmt.setInt(4, r.getEmployeeID());
			psmt.setString(5, r.getResolved());
			psmt.setString(6, r.getDate());
			psmt.setString(7, r.getWhoResolved());


			psmt.executeUpdate();
			con.close();
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
	}

	@Override
	public void deleteReimbursment(int id) {
		// TODO Auto-generated method stub
		Reimbursment rm = null;
		String sql = "DELETE FROM REIMBURSEMENT WHERE R_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");

			PreparedStatement ptsm = con.prepareStatement(sql);
			ptsm.setInt(1, id);

			ptsm.executeUpdate();
			
			
			System.out.println(rm);
			con.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReimbursment(Reimbursment r) {
		// TODO Auto-generated method stub
		
	}

}
