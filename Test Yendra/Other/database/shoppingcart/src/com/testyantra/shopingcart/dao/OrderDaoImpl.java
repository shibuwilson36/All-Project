package com.testyantra.shopingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.testyantra.shopingcart.bean.OrderBean;

public class OrderDaoImpl implements OrderDao {

	public boolean CreateOrder(OrderBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/shopping_cart_db";

			con = DriverManager.getConnection(url,"root","root");
			String sql = "insert into order_info values (?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getOrderId());
			pstmt.setInt(2, bean.getCustomerId());
			pstmt.setInt(3, bean.getProductId());



			int result = pstmt.executeUpdate();

			if (result > 0) {
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {

			if (pstmt!=null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con!=null) {

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
