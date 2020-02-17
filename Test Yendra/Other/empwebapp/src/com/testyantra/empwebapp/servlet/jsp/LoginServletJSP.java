package com.testyantra.empwebapp.servlet.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testyantra.empwebapp.bean.EmployeBean;
import com.testyantra.empwebapp.dao.EmployeDao;
import com.testyantra.empwebapp.util.EmployeManager;
@WebServlet("/jsplogin")
public class LoginServletJSP extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("empid"));
		String name=req.getParameter("password");
		 
		EmployeDao deo=EmployeManager.getInstance();
		EmployeBean bean=deo.authentication(id, name);
		
		
		
		if(bean!=null) {
			
			HttpSession session=req.getSession();
			session.setAttribute("EmployeBean", bean);
			resp.sendRedirect("./homepage.jsp");
			
			
		}
		else {

			req.setAttribute("name"," name");
			resp.sendRedirect("./login.jsp");
			
		}
		
	}
}
