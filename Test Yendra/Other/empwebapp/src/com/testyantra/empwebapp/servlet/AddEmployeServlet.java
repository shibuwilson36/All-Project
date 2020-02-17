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
@WebServlet("/add")
public class AddEmployeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("empid"));
		String name=req.getParameter("ename");
		int age=Integer.parseInt(req.getParameter("age"));
		String Password=req.getParameter("password");
		
		EmployeBean bean=new EmployeBean();
		bean.setId(id);
		bean.setName(name);
		bean.setAge(age);
		bean.setPassword(Password);
		
		EmployeDao dao=EmployeManager.getInstance();

 		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(bean.getId());
		out.println(bean.getName());
		out.println(bean.getAge());
		out.println(bean.getPassword());
		
		if(dao.addEmploye(bean)) {
			out.println("Welcome");
			out.println("Added");
			
		}
		else {
			out.println("Invalid id");
			req.getRequestDispatcher("/addemploye.html").include(req, resp);
		}
		out.println("</body>");
		out.println("</html>");
		
	}
}
