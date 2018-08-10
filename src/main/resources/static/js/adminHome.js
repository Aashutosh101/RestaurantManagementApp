if(sessionStorage.getItem("admin") === null) {
	var url = new URL(window.location.href);
	var c = url.searchParams.get("email");
	console.log(c);
	if(c === null) {
//		console.log("hh");
		window.location = ("/");
	} else {
//		console.log("gg");
		sessionStorage.setItem("admin", c);
		window.location = ("../html/adminHome.html");
	}
}

$(function() {
	console.log("Inside adminHome.js");
	$("#reservation_li").click(function(){
		$("#voucher_li").removeClass("active");
		$("#users_li").removeClass("active");
		$("reservation_li").addClass("active");
		getReservations();
	});

	$("#voucher_li").click(function(){
		console.log("Hello");
		$("#users_li").removeClass("active");
		$("#reservation_li").removeClass("active");
		$("#voucher_li").addClass("active");
		getVouchers();
	});

	$("#users_li").click(function(){
		console.log("Hello");
		$("#users_li").addClass("active");
		$("#reservation_li").removeClass("active");
		$("#voucher_li").removeClass("active");
		getUsers();
	});

	$("#logout_li").click(function(){
		sessionStorage.removeItem("admin");
		window.location = ("/");
	})

	getReservations();	  

	console.log("Get");
	
})