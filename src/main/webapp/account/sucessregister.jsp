<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<title>Account Info</title>
</head>
<body>

	<h3>Account Info</h3>
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<td>Username</td>
			<td>${person.username }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${person.password }</td>
		</tr>
		<tr>
			<td valign="top">Photo</td>
			<td>
				<img src="${pageContext.request.contextPath }/assets/images/${person.photo }" width="120">
			</td>
		</tr>
	</table>

</body>
</html>