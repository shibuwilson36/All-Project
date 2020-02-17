package com.testyantra.shopingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.testyantra.shopingcart.bean.ProductBean;


public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(ProductBean bean) {
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean isAdd=false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/shopping_cart_db";
			con=DriverManager.getConnection(url,"root","root");
			String sql="insert into shopping_cart_info values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);

			pstmt.setInt(1, bean.getProductId());
			pstmt.setString(2, bean.getProductName());
			pstmt.setString(3, bean.getBrand());
			pstmt.setDouble(4,bean.getPrice());
			pstmt.setDouble(5, bean.getQuntity());
			pstmt.setString(6, bean.getImage());

			int result=pstmt.executeUpdate();

			if(result>0) {

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
	public ProductBean searchEmpId(int id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductBean bean=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/shopping_cart_db";
			con=DriverManager.getConnection(url,"root","root");
			String sql="select * from shopping_cart_info where product_id =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				bean=new ProductBean();
				bean.setProductId(rs.getInt("product_id"));
			
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

		return bean;

	}

	@Override
	public ArrayList<ProductBean > getAllData() {
		
		Connection con=null;
		Statement pstmt=null;
		ResultSet rs=null;
		ArrayList<ProductBean > arrayList=new ArrayList<ProductBean>();
		ProductBean bean=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/shopping_cart_db";
			con=DriverManager.getConnection(url,"root","root");
			String sql="select * from shopping_cart_info ";
			pstmt=con.createStatement();
			rs=pstmt.executeQuery(sql);

			while(rs.next()) {
				
				
				 bean=new ProductBean();
				bean.setProductId(rs.getInt("product_id"));
				bean.setProductName(rs.getString("product_name"));
				bean.setBrand(rs.getString("brand"));
				System.out.println(bean.getProductId());
				arrayList.add(bean);

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

		return arrayList;

	
	}





}
