<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User HomePage</title>
<script type="text/javascript">
	
<%@include file="../js/dropDown.js"%>
	
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

	<form action="UserActivity" method="post" id="userActionForm">

		Activity List: <select name="item" id="activityList"
			onchange="dropDown()">
			<option value="select">--Select an Item--</option>
			<option value="defect">Defect</option>
			<option value="changeRequest">Change Request</option>

			<!--  	<option value="other">Other</option> -->
		</select> User Action: <select id="task" onchange="secondDropDown()">
			<option value="select">-- select one --</option>
		</select>

		<button type="button" value="proceed" onclick="showFormByID()">Proceed</button>
		<button type="submit" value="Submit">Submit</button>
	</form>
<br/><br/>
	<form action="#" id="createform" style="display: none">
		Defect Number: <input type="text" /><br>
		<br> Defect Description: <input type="text" /><br>
		<br> Defect Starting Date: <input type="text" /><br>
		<br> Time Booking: <input type="text"  /><br>
		<br> Initial Days Planned: <input type="text" /><br>
		<br>
		<button type="submit" value="submit">Create Defect</button>
	</form>
	<form action="#" id="updateform" style="display: none">
		Third name: <input type="text" name="fname"><br> Fourth
		name: <input type="text" name="lname"><br>
	</form>
	<form action="#" id="closeform" style="display: none">
		Fifth name: <input type="text" name="fname"><br> Sixth
		name: <input type="text" name="lname"><br>
	</form>

</body>
</html>