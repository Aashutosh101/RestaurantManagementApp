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

import com.visa.entity.RestaurantTable;
import com.visa.service.AdminService;

@RestController
public class TableController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="api/admin/restaurant/tables", method=RequestMethod.GET)
	public @ResponseBody List<RestaurantTable> getTables() {
		return adminService.getTables();
	}
	
	@RequestMapping(value="api/admin/restaurant/tables", method=RequestMethod.POST)
	public ResponseEntity<RestaurantTable> addRestaurantTable(@RequestBody RestaurantTable restaurantTable) {
		adminService.addTable(restaurantTable);
		return new ResponseEntity<RestaurantTable>(restaurantTable, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/admin/restaurant/tables/{tid}", method=RequestMethod.PUT)
	public ResponseEntity<RestaurantTable> updateRestaurantTable(@PathVariable("tid") String tid, @RequestBody RestaurantTable restaurantTable){
		adminService.updateTable(tid, restaurantTable);
		return new ResponseEntity<RestaurantTable>(restaurantTable, HttpStatus.OK);
	}
}
