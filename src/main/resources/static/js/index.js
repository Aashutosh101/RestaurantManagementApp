$(function() {
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