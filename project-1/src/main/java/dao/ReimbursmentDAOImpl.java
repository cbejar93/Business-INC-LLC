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
		String sql = "SELECT * FROM REIMBURSMENT";
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
	}

	@Override
	public Employee getReimbursmentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReimbursment(Reimbursment r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReimbursment(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReimbursment(Reimbursment r) {
		// TODO Auto-generated method stub
		
	}

}
