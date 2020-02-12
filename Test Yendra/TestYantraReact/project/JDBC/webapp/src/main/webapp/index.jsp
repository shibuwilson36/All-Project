<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%-- <%@taglib uri="" %> --%>
	<%@include file="index.html" %>
	<%@page import="java.util.Date"%> 
	<%@ page errorPage="error.jsp" %>
	<%@ page isThreadSafe="false" %>
	<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1 {
	color: aqua;
}
</style>
<%!int a = 10;%>
</head>
<body>
	<%
		Date date = new Date();
	/* System.out.println(1/0); */
	%>
	<h1><%=date%></h1>
	<h2 class="text-danger">
		Value =<%=a%></h2>
	<h2>
		Name =<%=name%>
	</h2>
</body>
</html>
<%!String name = "Nidhin";%>
<%!
public void jspInit(){
	System.out.println("Init methods");
}

public void jspDestroy(){
	System.out.println("Init jspDestroy");
}
%>

