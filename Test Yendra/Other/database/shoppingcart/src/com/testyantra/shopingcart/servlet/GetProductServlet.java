package com.testyantra.shopingcart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mysql.fabric.xmlrpc.base.Data;
import com.testyantra.shopingcart.bean.ProductBean;
import com.testyantra.shopingcart.dao.ProductDao;
import com.testyantra.shoppingcart.util.ProductManger;
@WebServlet("/getproduct")

public class GetProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Max-Age", "1728000");
        
		ProductBean bean= new ProductBean();
		ProductDao dao=ProductManger.getInstance();
		
		ArrayList< ProductBean> arrayList= dao.getAllData();
		
		PrintWriter out=resp.getWriter();
		JSONObject jsonObject=new JSONObject(); 
		jsonObject.put("key", arrayList);
		
		out.println(jsonObject.get("key"));
		
		


	}
}
