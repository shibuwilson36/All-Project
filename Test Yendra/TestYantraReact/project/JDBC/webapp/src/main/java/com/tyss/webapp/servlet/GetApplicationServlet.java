package com.tyss.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-app")
public class GetApplicationServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context=req.getServletContext();
		Object object=context.getAttribute("context");
		
		PrintWriter out =resp.getWriter();
		out.println("<html><body><h1>");
		
		out.println(object);
		
		out.println("</h1></body></html>");
	}

}
