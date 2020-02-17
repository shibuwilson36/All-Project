package com.testyantra.shopingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.testyantra.shopingcart.bean.WishListBean;

public class WishListDaoImpl implements WishListDao {
	public boolean addWishList(WishListBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isAdded= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart_db","root","root");

			String query="insert into wishlist values(?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,bean.getWishlist_Id());
			pstmt.setInt(2,bean.getCustomer_Id());
			pstmt.setInt(3,bean.getProduct_Id());
			
			int n =pstmt.executeUpdate();

			if(n>0) {
				isAdded= true;

			}


		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {


			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return isAdded;

	}
}
