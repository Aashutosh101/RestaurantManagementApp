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

import com.visa.entity.RestaurantTiming;
import com.visa.service.AdminService;

@RestController
public class RestaurantTimingController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="api/admin/restaurant/timings", method=RequestMethod.GET)
	public @ResponseBody List<RestaurantTiming> getRestaurantTimings() {
		return adminService.getRestaurantTimings();
	}
	
	@RequestMapping(value="api/admin/restaurant/timings", method=RequestMethod.POST)
	public ResponseEntity<RestaurantTiming> addRestaurantTiming(@RequestBody RestaurantTiming restaurantTiming) {
		adminService.addRestaurantTiming(restaurantTiming);
		return new ResponseEntity<RestaurantTiming>(restaurantTiming, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/admin/restaurant/timings/{tid}", method=RequestMethod.PUT)
	public ResponseEntity<RestaurantTiming> updateRestaurantTiming(@PathVariable("tid") String tid, @RequestBody RestaurantTiming restaurantTiming){
		adminService.updateRestaurantTiming(tid, restaurantTiming);
		return new ResponseEntity<RestaurantTiming>(restaurantTiming, HttpStatus.OK);
	}
}
