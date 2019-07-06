<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

	<h3>Welcome Page</h3>
	Welcome ${sessionScope.username }
	<br>
	<a href="${pageContext.request.contextPath }/admin/account?action=logout">Logout</a>

</body>
</html>