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
@WebServlet("/updateform")
public class UpdateFormServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("mmmmm");

		HttpSession session=req.getSession(false);
		EmployeBean bean= (EmployeBean) session.getAttribute("EmployeBean");

		if(bean!=null) {

			out.println("<form action='./update' method='post' >");
			out.println("<br>");
			
			out.println("<br>");
			out.println("<br>");
			out.println("Employe name........:");
			out.println("<input type='text' name='ename' value="+bean.getName()+">");
			out.println("<br>");
			out.println("<br>");
			out.println("Employe age...........:");
			out.println("<input type='number' name='age'value="+bean.getAge()+">");
			out.println("<br>");
			out.println("<br>");
			out.println("Employe password :");
			out.println("<input type='password' name='password' required=\"required\" >");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<input type='submit' name=age value='Update'>");
			out.println("</form>");
		}
		else {
			out.println("pls login ");

		}
		out.println("</body>");
		out.println("</html>");


	}
}


