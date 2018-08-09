package com.visa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.entity.Voucher;
import com.visa.service.AdminService;

@RestController
public class VoucherController {

	@Autowired
	public AdminService adminService;

	@RequestMapping(value = "api/admin/vouchers", method = RequestMethod.GET)
	public @ResponseBody List<Voucher> getVouchers() {
		return adminService.getAllVouchers();
	}

	@RequestMapping(value="api/admin/vouchers", method=RequestMethod.POST)
	public ResponseEntity<Voucher> addVoucher(@RequestBody Voucher voucher) {
		adminService.addVoucher(voucher);
		return new ResponseEntity<Voucher>(voucher, HttpStatus.CREATED);
	}

	@RequestMapping(value="api/admin/vouchers/{voucher_id}", method=RequestMethod.PUT)
	public ResponseEntity<Voucher> updateRestaurantTable(@PathVariable("voucher_id") String vid, @RequestBody Voucher voucher){
		adminService.updateVoucher(Integer.parseInt(vid), voucher);
		return new ResponseEntity<Voucher>(voucher, HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/user/voucher_validate", method = RequestMethod.GET)
	public @ResponseBody Voucher validateVoucher(String voucherCode) {
		return adminService.validateVoucher(voucherCode);
	}

}
