package com.tyss.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =resp.getWriter();
		
		Cookie cookie = new Cookie("fname","Shibu");
		
		resp.addCookie(cookie);
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("cookie");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	} 
}
