<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User HomePage</title>
<script>
$(document).ready(function () {
    $("#type").change(function () {
        var val = $(this).val();
        if (val == "defect") {
            $("#task").html("<option value='createDefect'>Create Defect</option><option value='updateDefect'>Update Defect</option><option value='deleteDefect'>Delete Defect</option>");
        } else if (val == "changeRequest") {
            $("#task").html("<option value='createChangeRequest'>Create CR</option><option value='updateChangeRequest'>Update CR</option><option value='deleteChangeRequest'>Delete CR</option>");
        } else if (val == "Other") {
            $("#task").html("<textarea rows="4" cols="50"></textarea>");
        } else if (val == "item0") {
            $("#task").html("<option value=''>--select one--</option>");
        }
    });
});
</script>


</head>
<body>
	<h3>
		Hello,
		<%=(String) request.getAttribute("username")%>
	</h3>
	<h3>
		Sucessfully Logged in As

		<%=(String) request.getAttribute("role")%>
	</h3>

	<form action="UserActivity" method="post">

		Activity List: <select name="item" id="type">
			<option value="select">--Select an Item--</option>
			<option value="defect">Defect</option>
			<option value="changeRequest">Change Request</option>
			<option value="other">Other</option> 
			</select>
		User Action:
			<select id="task">
				<option value="">-- select one --</option>
		</select>
	</form>

	<%
		String st = request.getParameter("item");
		if (st != null) {
			out.println("You have selected: " + st);
		}
	%>
</body>
</html>