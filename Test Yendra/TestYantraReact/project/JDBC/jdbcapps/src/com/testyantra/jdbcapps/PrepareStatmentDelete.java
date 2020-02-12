package com.testyantra.jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PrepareStatmentDelete {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement start=null;

		try {
			//Load the driver
			
			Class.forName("com.mysql.jdbc.Driver");
			//2 establish conection

			String url="jdbc:mysql://localhost:3306/info_employe_db";
			con=DriverManager.getConnection(url,"root","root");

			//3 issue the sql 
			String sql="DELETE FROM employe_info WHERE empid=?";
			start=con.prepareStatement(sql);
			start.setInt(1, Integer.parseInt(args[0]));
			//4  process the result
			
			int result=start.executeUpdate(); 
		
			if(result>0) {
				System.out.println("Data deleted");
			}else {
				System.out.println("Data not deleted");
			}

		} catch (Exception  e) {
			e.printStackTrace();
		}
		finally {
		
			if(start!=null) {
				try {
					start.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}


}

