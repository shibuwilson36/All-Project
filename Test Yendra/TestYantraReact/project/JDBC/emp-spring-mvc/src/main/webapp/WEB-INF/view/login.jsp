<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
p {
	color: red;
	size: 10px;
}

table {
	position: absolute;
	padding-top: 10%;
	padding-left: 40%;
}
</style>
</head>
<body>


	<form action="./login" method="post">
		<table>
			<tr>
				<td>User Email</td>
				<td>:</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>${msg}</td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>

		</table>
	</form>

</body>
</html>