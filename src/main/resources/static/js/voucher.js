function getVouchers() {
	console.log("Inside getVouchers");
	var voucherTemp$;
	var dashboard = $("#dashboard");
	console.log(dashboard);
	$.getJSON("http://localhost:8080/api/admin/vouchers", function(data) { 
		console.log(data);
		$.get("../html/voucher.html", function(templ) {
			console.log(templ);
			$("#dashboard").html(templ);
			var tb = $("#table_body");
			for(var i = 0 ; i < data.length ; i++) {
				console.log("Row append");
				tb.append(getVoucherRow(data[i]));
			}
		});
	})
}

function addVoucher() {
		
		postData = {}
		postData["voucherCode"] = $("#add_voucher_code").val();
		postData["valid"] = true;
		postData["user"] = {email: sessionStorage.getItem("admin")};
		console.log(JSON.stringify(postData));
		
		$.ajax({
		url: "/api/admin/vouchers/",
		type: "POST",
		data: JSON.stringify(postData),
		headers: {
			  "Content-type": "application/json"
		  },
		success: function() {
			toastr.success("Voucher Added");
			$("#addVoucherModal").modal("toggle");
			$.get("http://localhost:8080/api/user/voucher_validate?voucherCode=" + postData["voucherCode"], function(data) {
				$("#table_body").append(getVoucherRow(data));
			});
		}
	});
}

function updateVoucher(voucherId) {
	if($("#" + voucherId).val() === "True") {
		new_status = true;
	} else {
		new_status = false;
	}
	$.ajax({
		url: "/api/admin/vouchers/" + voucherId,
		type: "PUT",
		data: JSON.stringify({"valid": new_status}),
		headers: {
			  "Content-type": "application/json"
		  },
		success: function() {
			toastr.success("Status Updated");
		}
	});
}

function getVoucherRow(ele) {
	if(ele["valid"]) {
		ele["True"] = "selected";
		ele["False"] = "";
	} else {
		ele["False"] = "Selected";
		ele["True"] = "";
	}

	return "<tr> \
		        <td>" + ele["voucherId"] + "</td>\
		        <td>" + ele["voucherCode"] + "</td> \
                <td> \
			        <select id='" + ele["voucherId"] + "' onchange='updateVoucher(" + ele["voucherId"] + ")'>\
                        <option value='True' " + ele["True"] + ">True</option>\
                        <option value='False' " + ele["False"] + ">False</option>\
                    </select>\
                </td>\
		    </tr>"
}