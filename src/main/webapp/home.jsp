<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<h3>Sucessfully Logged in As Manager</h3>
<form action="ActionServlet" method="Post">  
    <input type="submit" name="action" value="AddUser">
    <input type="submit" name="action" value="ViewUserInformation">
</form>

</body>
</html>