package com.testyantra.jdbcapps;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJdbc {

	public static void main(String[] args) {
		Connection con=null;
		Statement start=null;
		ResultSet result=null;

		try {
			//Load the driver
//			Driver driver= new Driver();
//			DriverManager.registerDriver(driver);
			Class.forName("com.mysql.jdbc.Driver");
			//2 establish conection
			String url="jdbc:mysql://localhost:3306/info_employe_db?user=root&&password=root";
			con=DriverManager.getConnection(url);
//			String url="jdbc:mysql://localhost:3306/info_employe_db";
//			con=DriverManager.getConnection(url,"root","root");
			
			//3 issue the sql 
			start=con.createStatement();
			String sql="select * from employe_info";
			result=start.executeQuery(sql);
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

