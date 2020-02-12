package com.testyantra.jdbcapps;

import java.io.FileInputStream;
import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class RecordUpdate {

	public static void main(String[] args) {
		Connection con=null;
		Statement start=null;

		try {

			FileInputStream input = new FileInputStream("db.properties");
			Properties pro = new Properties();
			pro.load(input);
			//Load the driver
			
			Class.forName(pro.getProperty("driver"));
		

			String url=pro.getProperty("url");
			con=DriverManager.getConnection(url,pro);
	
			start=con.createStatement();
			String sql="UPDATE employe_info SET ename = 'Alfred Schmidt' WHERE empid=102";
			int result=start.executeUpdate(sql); 
		
			if(result>0) {
				System.out.println("Data updated");
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

