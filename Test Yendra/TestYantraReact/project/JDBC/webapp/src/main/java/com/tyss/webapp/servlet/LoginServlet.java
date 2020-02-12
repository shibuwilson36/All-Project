package com.tyss.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email=req.getParameter("email");
		String password=req.getParameter("password");
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		if(email.equals("shibu")&&password.equals("123")) {
			HttpSession session=req.getSession(true);
			session.setAttribute("email", email);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("./home");
			dispatcher.include(req, resp);
			out.println("login success");
		}else {
			out.println("Invalid passwor or Email");
			RequestDispatcher dispatcher=req.getRequestDispatcher("./login.html");
			dispatcher.include(req, resp);
		}

		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");



	}
}
