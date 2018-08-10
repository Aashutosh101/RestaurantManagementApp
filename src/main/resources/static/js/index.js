$(function() {
	var url = new URL(window.location.href);
	var c = url.searchParams.get("message");
	console.log(c);
	if(c != null) {
//		console.log("hh");
		toastr.error(c);
	} 

	$("#user").click(function(){
		console.log("User Clicked");
		$("#admin").removeClass("active");
		$("#user").addClass("active");
		$("#Login").attr("action", "/userLogin.do");
	});

	$("#admin").click(function(){
		console.log("Admin Clicked");
		$("#admin").addClass("active");
		$("#user").removeClass("active");
		$("#Login").attr("action", "/adminLogin.do");
	});
})