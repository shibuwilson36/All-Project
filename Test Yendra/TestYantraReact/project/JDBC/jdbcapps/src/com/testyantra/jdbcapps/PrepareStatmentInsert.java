package com.testyantra.jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PrepareStatmentInsert {

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
			String sql="insert into employe_info values(?,?,?,?,?,?)";
			start=con.prepareStatement(sql);
			start.setInt(1, Integer.parseInt(args[0]));
			start.setString(2, args[1]);
			start.setInt(3, Integer.parseInt(args[2]));
			start.setString(4, args[3]);
			start.setInt(5, Integer.parseInt(args[4]));
			start.setLong(6, Long.parseLong(args[5]));
			//4  process the result
			
			int result=start.executeUpdate(); 
		
			if(result>0) {
				System.out.println("Data added");
			}else {
				System.out.println("data not update");
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

