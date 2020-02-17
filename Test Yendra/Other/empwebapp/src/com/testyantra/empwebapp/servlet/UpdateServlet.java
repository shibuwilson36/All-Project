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
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);

		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");

		if(session!=null) {	
			EmployeBean bean1= (EmployeBean) session.getAttribute("EmployeBean");

			int id=bean1.getId();
			String name=req.getParameter("ename");
			int age=Integer.parseInt(req.getParameter("age"));
			String Password=req.getParameter("password");

			bean1.setId(id);
			bean1.setName(name);
			bean1.setAge(age);
			bean1.setPassword(Password);

			EmployeDao dao=EmployeManager.getInstance();




			if(dao.updateEmploye(bean1)) {
				out.println("Welcome");
				out.println("update");
				//req.getRequestDispatcher("/login").forward(req, resp);



			}
			else {
				out.println("not update");

				//req.getRequestDispatcher("./login").include(req, resp);
			}

		}
		else {

			out.println("pls login");
			req.getRequestDispatcher("/loginform.html").include(req, resp);

		}
		out.println("</body>");
		out.println("</html>");
	}


}
