if(sessionStorage.getItem("user") === null) {
	window.location = ("../index.html");
}

$(function(){
	var date_time = sessionStorage.getItem("date") + ", " + sessionStorage.getItem("time");
	$("#date_time").text(date_time);
	$("#people").text("Table for " + sessionStorage.getItem("people") + " persons");
	$("#selected_table").text(sessionStorage.getItem("table"));

	$("#checkout").click(function(event) {
		event.preventDefault();
		$("#error").css("display", "none");

		if($("#first_name").val() === "") {
			$("#error").text("Please Enter First Name");
			$("#error").css("display", "block");
			return;
		}

		if($("#email").val() === "") {
			$("#error").text("Please Enter Email");
			$("#error").css("display", "block");
			return;
		}

		if($("#phone").val() === "") {
			$("#error").text("Please Enter Phone");
			$("#error").css("display", "block");
			return;
		}

		//Validate Voucher

		var reservation = {};
		reservation["user"] = {"email": sessionStorage.getItem("email")};
		reservation["rTable"] = {"id": parseInt(sessionStorage.getItem("table"))};
		reservation["date"] = sessionStorage.getItem("date");
		reservation["time"] = sessionStorage.getItem("time");
		reservation["status"] = "Confirmed";
		reservation["title"] = $("#title").val();
		reservation["fName"] = $("#first_name").val();
		reservation["lName"] = $("#last_name").val();
		reservation["email"] = $("#email").val();
		reservation["phone"] = $("#phone").val();
		reservation["voucher"] = $("#voucher").val();
		reservation["noOfPeople"] = parseInt(sessionStorage.getItem("people"));

		console.log(JSON.stringify(reservation));
	});
});