<html>
<body>
	<a href="./home">home</a>
	<a style="float: right" href="#">logout</a>
	<form action="./register" method="post">
		<table>
			<tr>
				<td>${msg }</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td>:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>User Email</td>
				<td>:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>User Mobile</td>
				<td>:</td>
				<td><input type="number" name="mobile"></td>
			</tr>
			<tr>
				<td>Role</td>
				<td>:</td>
				<td><select  name="role">
						<option value="ADMIN">Admin</option>
						<option value="USER">USER</option>
				</select></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>
