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
import com.testyantra.empwebapp.dao.EmployeDaoImp;
import com.testyantra.empwebapp.util.EmployeManager;
@WebServlet("/search")
public class SerarchEmployeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);

		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");		

		if(session!=null)
		{
			

			int id=Integer.parseInt(req.getParameter("empid"));

			EmployeDao dao=EmployeManager.getInstance();


			EmployeBean e1=dao.searchEmpId(id);

			
			if(e1!=null) {
				out.println("employe id="+e1.getId());
				out.println("employe id="+e1.getName());
				out.println("employe id="+e1.getAge());

			}
			else {
				out.println("id not found");
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
