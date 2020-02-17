package com.testyantra.shopingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testyantra.shopingcart.bean.CartBean;
import com.testyantra.shopingcart.bean.ProductBean;
import com.testyantra.shopingcart.dao.CartDao;
import com.testyantra.shopingcart.dao.ProductDao;
import com.testyantra.shoppingcart.util.CartManger;
import com.testyantra.shoppingcart.util.ProductManger;


@WebServlet("/addcart")

public class AddCartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		int customerId=Integer.parseInt(req.getParameter("customerId"));
		int productId=Integer.parseInt(req.getParameter("wishId"));

		CartBean bean= new CartBean();

		bean.setCustomerId(customerId);;
		bean.setProductId(productId);

		CartDao dao=CartManger.getInstance();

		dao.addCart(bean);
		PrintWriter out=resp.getWriter();
 
		out.println("<html>");
		out.println("<body>");
		 
		out.println("</body>");
		out.println("</html>");

	}
}




