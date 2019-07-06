<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Register</title>
</head>
<body>

	<h3>Account Info</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<td>Username</td>
			<td>${account.username }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${account.password }</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${account.age }</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${account.email }</td>
		</tr>
		<tr>
			<td>Website</td>
			<td>${account.website }</td>
		</tr>
	</table>

</body>
</html>