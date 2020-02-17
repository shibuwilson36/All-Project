package com.testyantra.empwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.testyantra.empwebapp.bean.EmployeBean;

public class EmployeDaoImp implements EmployeDao {

	@Override
	public EmployeBean searchEmpId(int id) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeBean eb=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/info_employe_db";
			con=DriverManager.getConnection(url,"root","root");
			String sql="select * from employe_info where empid =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				eb=new EmployeBean();
				eb.setId(rs.getInt("empid"));
				eb.setName(rs.getString("ename"));
				eb.setAge(rs.getInt("age"));
			}
		 
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
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
		
		return eb;
	}
	
	
	
	public EmployeBean authentication(int id,String password) {
		
		Connection con=null; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		EmployeBean eb=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/info_employe_db";
			con=DriverManager.getConnection(url,"root","root");
			String sql="select * from employe_info where empid =? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				eb=new EmployeBean();
				eb.setId(rs.getInt("empid"));
				eb.setName(rs.getString("ename"));
				eb.setAge(rs.getInt("age"));
			}
		 
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
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
		
		return eb;
	
	}



	@Override
	public boolean addEmploye(EmployeBean bean) {

		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isAdd=false;
		int rs=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/info_employe_db";
			con=DriverManager.getConnection(url,"root","root");
			String sql="insert into employe_info values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getPassword());
			rs=pstmt.executeUpdate();
			
			if(rs>0) {
				
				isAdd=true;
			}
		 
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			if(pstmt!=null) {
				try {
					pstmt.close();
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
		
		return isAdd;
	}
 


	
	
	@Override
	public boolean updateEmploye(EmployeBean bean) {
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isUpdate=false;
		int rs=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/info_employe_db";
			con=DriverManager.getConnection(url,"root","root");
			String sql="update employe_info set ename=?, age=?,password=? where empid=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(4, bean.getId());
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getAge());
			pstmt.setString(3, bean.getPassword());
			rs=pstmt.executeUpdate();
			
			if(rs>0) {
				
				isUpdate=true;
			}
		 
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			if(pstmt!=null) {
				try {
					pstmt.close();
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
		
		return isUpdate;

	}

}
