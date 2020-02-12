package com.testyantra.jdbcapps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PrepareStatment {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement start=null;
		ResultSet result=null;

		try {
			//Load the driver
			
			Class.forName("com.mysql.jdbc.Driver");
			//2 establish conection

			String url="jdbc:mysql://localhost:3306/info_employe_db";
			con=DriverManager.getConnection(url,"root","root");

			//3 issue the sql 
			String sql="select * from employe_info where empid=?";
			start=con.prepareStatement(sql);
			start.setInt(1, Integer.parseInt(args[0]));
			result=start.executeQuery();
			//4  process the result
			while(result.next()) {
				System.out.println("Employe Id          :"+result.getInt("empid"));
				System.out.println("Employe Name        :"+result.getString("ename"));
				System.out.println("Employe Age         :"+result.getInt("age"));
				System.out.println("Employe Salary      :"+result.getInt("salary"));
				System.out.println("Employe Mobile      :"+result.getLong("mobile"));
				System.out.println("Employe Password    :"+result.getString("password"));
				System.out.println("............................");
			}

		} catch (Exception  e) {
			e.printStackTrace();
		}
		finally {
			if(result!=null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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

