function getUsers() {
	console.log("Inside getUsers");
	var userTemp$;
	var dashboard = $("#dashboard");
	console.log(dashboard);
	$.getJSON("http://localhost:8080/api/admin/users", function(data) { 
		console.log(data);
		$.get("../html/user.html", function(templ) {
			console.log(templ);
			$("#dashboard").html(templ);
			var tb = $("#table_body");
			for(var i = 0 ; i < data.length ; i++) {
				console.log("Row append");
				tb.append(getUserRow(data[i]));
			}
		});
	})
}

function updateUserStatus(email, obj) {
	var status = $(obj).val();
	var role = $(obj).parent().prev().children().val();
	$.ajax({
		url: "/api/admin/" + email,
		type: "PUT",
		data: JSON.stringify({"status": status, "role": role}),
		headers: {
			  "Content-type": "application/json"
		  },
		success: function() {
			toastr.success("Status Updated");
		}
	});
}

function updateUserRole(email, obj) {
	var role = $(obj).val();
	var status = $(obj).parent().next().children().val();
	$.ajax({
		url: "/api/admin/" + email,
		type: "PUT",
		data: JSON.stringify({"status": status, "role": role}),
		headers: {
			  "Content-type": "application/json"
		  },
		success: function() {
			toastr.success("Role Updated");
		}
	});
}

function addUser() {
		
		postData = {}
		postData["email"] = $("#add_user_email").val();
		postData["firstName"] = $("#add_user_fname").val();
		postData["lastName"] = $("#add_user_lname").val();
		postData["phone"] = $("#add_user_phone").val();
		postData["password"] = $("#add_user_password").val();
		postData["status"] = $("#add_user_status").val();
		postData["role"] = $("#add_user_role").val();
		
		console.log(JSON.stringify(postData));
		
		$.ajax({
		url: "/api/admin/users/",
		type: "POST",
		data: JSON.stringify(postData),
		headers: {
			  "Content-type": "application/json"
		  },
		success: function() {
			toastr.success("User Added");
			$("#addUserModal").modal("toggle");
			$.get("http://localhost:8080/api/admin/users/" + postData["email"], function(data) {
				$("#table_body").append(getUserRow(data));
			});
		}
	});
}


function getUserRow(ele) {
	ele["Admin"] = "";
	ele["User"] = "";

	ele["Active"] = "";
	ele["Inactive"] = "";

	if(ele["role"] === "Admin") {
		ele["Admin"] = "selected";
	} else {
		ele["User"] = "selected";
	}

	if(ele["status"] === "Active") {
		ele["Active"] = "selected";
	} else {
		ele["Inactive"] = "selected";
	}

	return "<tr> \
		        <td>" + ele["email"] + "</td>\
		        <td>" + ele["firstName"] + " " + ele["lastName"] + "</td> \
		    	<td>" + ele["phone"] + "</td>\
                <td> \
			        <select onchange='updateUserRole(\"" + ele["email"] + "\", this)'>\
                        <option value='Admin' " + ele["Admin"] + ">Admin</option>\
                        <option value='User' " + ele["User"] + ">User</option>\
                    </select>\
                </td>\
                <td> \
			        <select onchange='updateUserStatus(\"" + ele["email"] + "\", this)'>\
                        <option value='Active' " + ele["Active"] + ">Active</option>\
                        <option value='Inactive' " + ele["Inactive"] + ">Inactive</option>\
                    </select>\
                </td>\
		    </tr>"
}