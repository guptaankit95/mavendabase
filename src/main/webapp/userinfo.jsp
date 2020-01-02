<%@page import="com.model.User"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="../css/usertable.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Information</title>
</head>
<body>
	<h3>User Information goes here</h3>
	<form action="ViewUsers" method="post">
		<input type="submit" value="SeeAllUsers" />

	<table>
		<tr>
			<th>UserID</th>
			<th>UserName</th>
			<th>UserSkill</th>
		</tr>
		<tbody>
			<%
				User user = new User();
				ArrayList<User> users = new ArrayList();
				users = (ArrayList<User>) request.getAttribute("userList");
				out.println("size of users is " + users.size());
				for (int i = 0; i < users.size(); i++) {
			%>
			<tr>
				<td><%=users.get(i).getId()%></td>
				<td><%=users.get(i).getUserName()%></td>
				<td>SAP MII</td>
			</tr>

			<%
				}
			%>
		</tbody>

	</table>
	</form>
</body>
</html>