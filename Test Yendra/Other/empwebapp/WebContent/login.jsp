<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%String msg=(String)request.getAttribute("name"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./style.css" rel="stylesheet">
</head>
<body>
	<div class="nav">
		<a href="#">HOME</a> <a href="#">SERVICES</a> <a href="#">GALLERY</a>
		<a href="#">CONTACT</a> <a href="#">ABOUT</a> <a href="login.jsp">LOGIN</a>
		<div class="search">
			<form action="./search" >
				<input type="text" name="empid" placeholder="Search..">
				<button>Search</button>
			</form>
		</div>
	</div>
	<div class="login-box">
		<%if(msg!=null){%>
		<%=msg %>
		<%} %>
		<form action="./jsplogin" method="post">
			
			<table class="table" >
				<tr>
					<td>User Id</td>
					<td>:</td>
					<td><input type="text" name="empid" required="required"></td>
				</tr >
				<tr>
				</tr>
				<tr>
					<td>password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
				<td></td>
				</tr>
				<tr>
				<td></td>
				</tr>
				<tr>
				<td></td>
				<td></td>
					<td align="left"><input class="btn" type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="image">image</div>
</body>
</html>