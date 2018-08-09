$(function() {
	$("#message").addClass(sessionStorage.getItem("status"));
	$("#message").text(sessionStorage.getItem("message"));
})