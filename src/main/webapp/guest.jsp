<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*,com.demo.entities.Guest"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>JPA Guest Book Web Application Tutorial</title>
</head>

<body>

	<h1>Adding Guests</h1>
	<form method="POST" action="guest">
		Name: <input type="text" name="name" />


		<div>

			Host <select name="host" style="padding: 5px; margin-top: 5px;">
				<c:forEach var="host" items="${hosts}">
					<option value="<c:out value='${host.id}' />">
						<c:out value='${host.fullname}' />
					</option>
				</c:forEach>
			</select>
			<ul>
				<c:forEach var="host" items="${hosts}">
					<li><c:out value='${host.fullname}'  /> <c:out value='${host.guests}'  /></li>
					<%-- <c:forEach var="guest" items="${host.guests}">
						<li><c:out value='${guest}' /></li>
					</c:forEach> --%>
				</c:forEach>
			</ul>
		</div>



		<input type="submit" style="padding: 5px; margin-top: 5px;"
			value="Add" />

	</form>

	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Guest> guests = (List<Guest>) request.getAttribute("guests");
			if (guests != null) {
				for (Guest guest : guests) {
		%>
		<li> Hosts  <%=guest.getHost().getFullname()%> <br>  Guests <%=guest%>  
		</li>
		<%
			}
			}
		%>
	</ol>
	<hr>


</body>
</html>