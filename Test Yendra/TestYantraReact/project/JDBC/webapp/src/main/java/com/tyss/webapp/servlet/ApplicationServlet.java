package com.tyss.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-app")
public class ApplicationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context=req.getServletContext();
		context.setAttribute("context",new Object());
		PrintWriter out =resp.getWriter();
		out.println("<html><body><h1>");
		
		out.println("Created context object ");
		
		out.println("</h1></body></html>");
	
	}
}
