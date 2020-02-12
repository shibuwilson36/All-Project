package com.tyss.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Homeservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =resp.getWriter();		
		HttpSession  session=req.getSession(false);
		out.println("<html>");
		out.println("<body>");
		if(session!=null) {
			out.println("<h1>");
			out.println(session.getAttribute("email"));
			
			out.println("<a href='./logout'>logout<a>");
			out.println("</h1>");

		}else {
			out.println("pls login");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);

		}
		out.println("</body>");
		out.println("</html>");
	}

}
