<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.empspringmvc.dto.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	EmployeeInfoBean bean = (EmployeeInfoBean) session.getAttribute("bean");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%
		if (bean != null) {
			if (bean.getRole().equalsIgnoreCase("ADMIN")) {
	%>
	<a href="./register">Add Employee</a>
	<%
		}
		}
	%>
	<a href="./change-password">Change Password</a>
	<a style="float: right" href="./logout">logout</a>
	<h1>
		Welcome
		<%=bean.getName()%></h1>

	<form action="./search">
		<input type="text" name="name" placeholder="search...."> <input
			type="submit" value="search">
	</form>


	<%
		List<EmployeeInfoBean> beans = (List<EmployeeInfoBean>) request.getAttribute("beans");
	%>
	<%
		if (beans != null) {
			if (beans.isEmpty()) {
	%>
	<h3>DATA NOT FOUND</h3>
	<%
		} else {
	%>
	<table class="table">
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Mobile</td>
			<td>Role</td>
		</tr>
		<%
			for (EmployeeInfoBean b : beans) {
		%>

		<tbody>
			<tr>
				<td><%=b.getName()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getMobile()%></td>
				<td><%=b.getRole()%></td>
			</tr>
		</tbody>

	</table>

	<%
		}
			}
		}
	%>

</body>
</html>