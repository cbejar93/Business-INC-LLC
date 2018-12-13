package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final String filename = "connection.properties";
		 try {
			Connection con = ConnectionUtil.getConnection(filename);
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	

}


