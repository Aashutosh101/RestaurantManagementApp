function getReservations() {
	console.log("Inside getReservations");
	var reserveTemp$;
	var dashboard = $("#dashboard");
	console.log(dashboard);
	$.getJSON("http://localhost:8080/api/admin/reservations", function(data) { 
		console.log(data);
		$.get("../html/reservation.html", function(templ) {
			console.log(templ);
			$("#dashboard").html(templ);
			var tb = $("#table_body");
			for(var i = 0 ; i < data.length ; i++) {
				console.log("Row append");
				tb.append(getReservationRow(data[i]));
			}
		});
	})
}

function updateReservation(reservationId) {
	var new_status = $("#" + reservationId).val();
	$.ajax({
		url: "/api/admin/reservations/" + reservationId,
		type: "PUT",
		data: JSON.stringify({"status": new_status}),
		headers: {
			  "Content-type": "application/json"
		  },
		success: function() {
			toastr.success("Status Updated");
		}
	});
}

function getReservationRow(ele) {
	ele["Confirmed"] = "";
	ele["Pending"] = "";
	ele["Cancelled"] = "";
	ele["Enquiry"] = "";

	switch(ele["status"]) {
		case "Confirmed" : ele["Confirmed"] = "selected"; break;
		case "Pending" : ele["Pending"] = "selected"; break;
		case "Cancelled" : ele["Cancelled"] = "selected"; break;
		case "Enquiry" : ele["Enquiry"] = "selected"; break;
	}

	return "<tr> \
		        <td>" + ele["reservedFrom"] + "</td>\
		        <td>" + ele["fName"] + " " + ele["lName"] + "</td> \
		    	<td>" + ele["email"] + "</td>\
		    	<td>" + ele["rTable"]["id"] + "</td>\
		    	<td>" + ele["noOfPeople"] + "</td>\
                <td> \
			        <select id='" + ele["reservationId"] + "' onchange='updateReservation(" + ele["reservationId"] + ")'>\
                        <option value='Confirmed' " + ele["Confirmed"] + ">Confirmed</option>\
                        <option value='Cancelled' " + ele["Cancelled"] + ">Cancelled</option>\
                        <option value='Enquiry' " + ele["Enquiry"] + ">Enquiry</option>\
                        <option value='Pending' " + ele["Pending"] + ">Pending</option>\
                    </select>\
                </td>\
		    </tr>"
}