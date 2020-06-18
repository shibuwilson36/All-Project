package com.testyantra.shopingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testyantra.shopingcart.bean.OrderBean;
import com.testyantra.shopingcart.dao.OrderDao;
import com.testyantra.shoppingcart.util.OrderManager;

@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int customerId = Integer.parseInt(req.getParameter("customerId"));

		int productId = Integer.parseInt(req.getParameter("productId"));


		OrderBean bean = new OrderBean();
		bean.setCustomerId(customerId);
		bean.setProductId(productId);

		OrderDao dao = OrderManager.getInstant();
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (dao.CreateOrder(bean)) {
			out.println("Suuccessfully Created");
		} else {
			out.println("not Created");
		}

		out.println("</html>");
		out.println("</body>");

	}
}