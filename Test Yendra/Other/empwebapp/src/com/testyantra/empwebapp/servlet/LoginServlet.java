package com.testyantra.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testyantra.empwebapp.bean.EmployeBean;
import com.testyantra.empwebapp.dao.EmployeDao;
import com.testyantra.empwebapp.util.EmployeManager;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id=Integer.parseInt(req.getParameter("empid"));
		String name=req.getParameter("password");
		 
		EmployeDao deo=EmployeManager.getInstance();
		
		EmployeBean bean=deo.authentication(id, name);
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(bean!=null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("EmployeBean", bean);
			out.println("Welcome");
			out.println(bean.getName());

			out.println("<br>");
			out.println("<a href='./search.html'>search</a>");
			out.println("<br>");
			out.println("<a href='./addemploye.html'>Add Employe</a>");
			out.println("<br>");
			out.println("<a href='./updateform'>update Employe</a>");
			out.println("<br>");
			out.println("<a href='./logout'>logout</a>");
			
		}
		else {
			out.println("Invalid user password");
			req.getRequestDispatcher("/loginform.html").include(req, resp);
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}
