function dropDown() {

	var selectedValue = document.getElementById("activityList").value;
	alert("user has selected " + selectedValue);

	// var toBePopulated = document.getElementById("task");
	// alert("to be populated "+ toBePopulated);
	if (selectedValue == "defect") {
		alert("first choice selected ");
		document.getElementById("task").innerHTML = "<option value='createDefect'>Create Defect</option>"
				+ "<option value='updateDefect'>Update Defect</option>"
				+ "<option value='closeDefect'>Close Defect</option>";
	}
	if (selectedValue == "changeRequest") {
		alert("Second choice selected ");
		document.getElementById("task").innerHTML = "<option value='createRequest'>Create Request</option>"
				+ "<option value='updateRequest'>Update Request</option>"
				+ "<option value='closeRequest'>Close Request</option>";
	}
	/*
	 * if (selectedValue == "other") { alert("Third choice selected ");
	 * document.getElementById("task").innerHTML = "<option
	 * value='createDefect'>Create Defect</option><option
	 * value='updateDefect'>Update Defect</option><option
	 * value='deleteDefect'>Delete Defect</option>"; }
	 */
	if (selectedValue == "select") {
		document.getElementById("task").innerHTML = "<option value = \"\">-- select one --</option>";

	}

}

function secondDropDown() {
	var secondDropdownValue = document.getElementById("task").value;
	alert("second Drop down value is " + secondDropdownValue);
}

function showFormByID() {

	var firstDropDownValue = document.getElementById("activityList").value;
	var secondDropDownValue = document.getElementById("task").value;

	if ((firstDropDownValue != "select" && secondDropDownValue != "select")) {

		if ((firstDropDownValue != "" && secondDropDownValue != "")) {

			alert("selected values from first dropdown is "
					+ firstDropDownValue + " and from second dropdown value = "
					+ secondDropDownValue);

			if (secondDropDownValue == "createDefect") {
				document.getElementById("updateform").style.display = "none";
				document.getElementById("closeform").style.display = "none";
				document.getElementById("createform").style.display = "block";

			} else if(secondDropDownValue == "updateDefect") {
				document.getElementById("createform").style.display = "none";
				document.getElementById("closeform").style.display = "none";
				document.getElementById("updateform").style.display = "block";
				
			}else if(secondDropDownValue == "closeDefect") {
				document.getElementById("createform").style.display = "none";
				document.getElementById("updateform").style.display = "none";
				document.getElementById("closeform").style.display = "block";
				
			}
			else{
				document.getElementById("createform").style.display = "none";
				document.getElementById("updateform").style.display = "none";
				document.getElementById("closeform").style.display = "none";
			}
		}
	}

}

function changeForm(form) {
	for (var i = 0; i < form.length; i++) {
		var form_op = form.options[i].value;
		if (form_op == form.value) {
			document.getElementsByName(form_op)[0].style.display = "block";
		} else {
			document.getElementsByName(form_op)[0].style.display = "none";
		}
	}
}