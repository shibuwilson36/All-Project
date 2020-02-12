package com.testyantra.jdbcapps;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyFirstJdbcPropertyFile {

	public static void main(String[] args) {

		Connection con=null;
		Statement start=null;
		ResultSet result=null;

		try {
			FileInputStream input = new FileInputStream("db.properties");
			Properties pro = new Properties();
			pro.load(input);
			//Load the driver
			
			Class.forName(pro.getProperty("driver"));
			//2 establish conection
			
			
			String url=pro.getProperty("url");
			con=DriverManager.getConnection(url,pro);

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