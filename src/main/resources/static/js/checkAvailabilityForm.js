if(sessionStorage.getItem("user") === null) {
	window.location = ("../index.html");
}

$(function() {
	sessionStorage.removeItem("date");
	sessionStorage.removeItem("time");
	sessionStorage.removeItem("people");
	sessionStorage.removeItem("table");


	$("#check_availability").click(function(event) {
		event.preventDefault();

		$("#error").css("display", "none");

		var date = $("#date").val();
		var time = $("#time").val();
		var people = $("#people").val();

		if(date === "") {
			$("#error").text("Please Select Date");
			$("#error").css("display", "block");
			return;
		} else if(time === "") {
			$("#error").text("Please Select Time");
			$("#error").css("display", "block");
			return;
		} else if(people === "") {
			$("#error").text("Please select no. of people");
			$("#error").css("display", "block");
			return;
		} else if(parseInt(people) < 0) {
			$("#error").text("No. of people cannot be less than 0");
			$("#error").css("display", "block");
			return;
		} else if(parseInt(people) > 20) {
			$("#error").text("No. of people cannot be greater than 20");
			$("#error").css("display", "block");
			return;
		}


		sessionStorage.setItem("date", formatDate(date));
		sessionStorage.setItem("time", time);
		sessionStorage.setItem("people", people);

		var data = {};
		data["date"] = formatDate(date);
		data["time"] = time;
		data["noOfPeople"] = parseInt(people);

		$.getJSON("https://my-json-server.typicode.com/shoonya26/myjson/tables?" + $.param(data), function(data) {
			if(data.length == 0) {
				$("#error").text("No seats available for selected date and time");
				$("#error").css("display", "block");
				return;
			}

			for(var i=0 ; i<data.length ; i++) {
				var id = "table" + data[i]["id"];
				$("#" + id).css("background-color", "green");
				$("#" + id).click(function() {
					$(".selected_table").css("background-color", "green");
					$(".selected_table").removeClass("selected_table");
					$(this).css("background-color", "red");
					$(this).addClass("selected_table");
				});
			}
		});
		$("#availability_details").css("display", "block");
	});

	$("#proceed_book").click(function() {
		if($(".selected_table").length == 0) {
			alert("Please select a table");
		} else {
			sessionStorage.setItem("table", $(".selected_table")[0].innerText);
			window.location = ("bookingForm.html");
		}
	});
});

function formatDate(inputFormat) {
  function pad(s) { return (s < 10) ? '0' + s : s; }
  var d = new Date(inputFormat);
  return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('-');
}