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

		var tt = false;
		var vid;
		//Validate Voucher
		console.log("Here1 ");
		$.get("http://localhost:8080/api/user/voucher_validate?voucherCode=" + $("#voucher").val(), function(data) {
			console.log(data);
			if(data === "") {
				$("#error").text("Invalid Voucher");
				$("#error").css("display", "block");
				tt = true;
				return;
			} else {
				console.log(JSON.stringify(data));
				data = JSON.parse(JSON.stringify(data));
				vid = data["voucherId"];
				console.log("sdhfsgjvhs");
				if(tt) return;

				var reservation = {};
				reservation["user"] = {"email": sessionStorage.getItem("user")};
				reservation["rTable"] = {"id": parseInt(sessionStorage.getItem("table"))};
				// reservation["date"] = sessionStorage.getItem("date");
				// reservation["time"] = sessionStorage.getItem("time");
				reservation["reservedFrom"] = sessionStorage.getItem("date") + " " + sessionStorage.getItem("time");
				reservation["status"] = "Pending";
				reservation["title"] = $("#title").val();
				reservation["fName"] = $("#first_name").val();
				reservation["lName"] = $("#last_name").val();
				reservation["email"] = $("#email").val();
				reservation["phone"] = $("#phone").val();
				reservation["voucher"] = {"voucherId": parseInt(vid)};
				reservation["noOfPeople"] = parseInt(sessionStorage.getItem("people"));

				console.log(JSON.stringify(reservation));
//				$.post("/api/users/register/checkout", JSON.stringify(reservation), function(data, status) {
//					console.log(status);
//				});
				
				$.ajax({
					  type: "POST",
					  url: "/api/users/register/checkout",
					  data: JSON.stringify(reservation),
					  headers: {
						  "Content-type": "application/json"
					  },
					  cache: false,
					  success: function(data){
					     console.log(data);
					  }
					});
				sessionStorage.setItem("status", "success");
				sessionStorage.setItem("message", "Your Reservation has been created");
				window.location = ("../html/checkAvailabilityForm.html?email=" + sessionStorage.getItem("user"));
			}
		});
		
		
		
	});
});