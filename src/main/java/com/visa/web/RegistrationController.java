package com.visa.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.entity.RestaurantTable;
import com.visa.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="api/users/register/checkAvailability" , method=RequestMethod.GET)
	public  @ResponseBody List<RestaurantTable> checkAvailability(@RequestParam("date") String date,@RequestParam("time") String time,@RequestParam("noOfPeople") int noOfPeople) throws RestaurantApiException {
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		List<RestaurantTable> availableTables=null;
		try {
			Date fromDate = datetimeFormatter.parse(date+" "+time);
			availableTables=userService.checkAvailability(fromDate, noOfPeople);
		//	availableTables.add(new RestaurantTable(0,4));
			return availableTables;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RestaurantApiException(date + " " + time,  e.getMessage(), e);
		}
	}
	
	@RequestMapping(value="api/users/register/checkout", method=RequestMethod.POST)
	public ResponseEntity<String> checkout(@RequestBody String reservation){
		System.out.println(reservation);
		return null;
	}
}
