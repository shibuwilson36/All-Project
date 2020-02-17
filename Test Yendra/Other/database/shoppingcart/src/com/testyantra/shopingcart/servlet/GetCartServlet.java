package com.testyantra.shopingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testyantra.shopingcart.bean.ProductBean;
import com.testyantra.shopingcart.dao.ProductDao;
import com.testyantra.shoppingcart.util.ProductManger;
@WebServlet("/getcart")
public class GetCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ProductBean bean= new ProductBean();
		ProductDao dao=ProductManger.getInstance();
		
		ArrayList< ProductBean> arrayList= dao.getAllData();
		
		System.out.println(arrayList.get(0).getProductId());
		PrintWriter out=resp.getWriter();
 
	
		out.println(arrayList.get(0).getProductId());
		


	}
}
