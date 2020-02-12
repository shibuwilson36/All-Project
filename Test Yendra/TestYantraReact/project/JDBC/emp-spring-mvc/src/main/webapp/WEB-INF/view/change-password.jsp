<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>

	<a href="./home">home</a>
	<a style="float: right" href="#">logout</a>
	<form action="./change-password" method="post">
		<table>
			<tr>
				<td>New Password</td>
				<td>:</td>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Change"></td>
			</tr>

		</table>
	</form>

</body>
</html>