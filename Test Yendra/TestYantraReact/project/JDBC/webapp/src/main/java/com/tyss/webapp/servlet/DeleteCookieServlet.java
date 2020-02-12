package com.tyss.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete-cookie")
public class DeleteCookieServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookie = req.getCookies();
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		
		for (Cookie cookie2 : cookie) {
			if(cookie2.getName().equals("name")) {
				cookie2.setMaxAge(0);
				resp.addCookie(cookie2);
				
			}
		}
		out.println("<h1>");
		out.println("Deleted");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");

	}
}
