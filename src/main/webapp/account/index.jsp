<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Register</title>
</head>
<body>

	<h3>Register Account</h3>
	   ${errors }
	<form method="post" action="${pageContext.request.contextPath }/account">
		<table cellpadding="2" cellspacing="2">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="${account.username }"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value="${account.password }"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" value="${account.age }"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${account.email }"></td>
			</tr>
			<tr>
				<td>Website</td>
				<td><input type="text" name="website" value="${account.website }"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>

</body>
</html>