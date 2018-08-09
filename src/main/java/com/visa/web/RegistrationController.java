package com.visa.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.dao.RestaurantTimingDao;
import com.visa.entity.Reservation;
import com.visa.entity.RestaurantTable;
import com.visa.entity.RestaurantTiming;
import com.visa.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="api/users/register/checkAvailability" , method=RequestMethod.GET)
	public  @ResponseBody List<RestaurantTable> checkAvailability(@RequestParam("date") String date,@RequestParam("time") String time,@RequestParam("noOfPeople") int noOfPeople) throws RestaurantApiException, TimeOutOfBoundsException {
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		List<RestaurantTable> availableTables=null;
		try {
			Date fromDate = datetimeFormatter.parse(date+" "+time);
			RestaurantTiming rt=userService.getRestaurantTimingByDay(fromDate.getDay());
			if(!checkInRange(time,rt.getStartTime(),rt.getEndTime())) {
				throw new TimeOutOfBoundsException(date + " " + time,  "Restaurant closed during those hours");
			}
			availableTables=userService.checkAvailability(fromDate, noOfPeople);
			return availableTables;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RestaurantApiException(date + " " + time,  e.getMessage(), e);
		}
	}
	
	private boolean checkInRange(String time, String startTime, String endTime) throws ParseException {
		SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss");
		Date ttime = timeFormatter.parse(time);
		Date tstartTime = timeFormatter.parse(startTime);
		Date tendTime = timeFormatter.parse(endTime);
		if( (ttime.after(tstartTime) || ttime.equals(tstartTime)) && ttime.before(tendTime))
			return true;
		
		return false;
	}

	@RequestMapping(value="api/users/register/checkout", method=RequestMethod.POST)
	public ResponseEntity<String> checkout(@RequestBody Reservation reservation){
		userService.checkout(reservation);
		return new ResponseEntity<String> ("Your reservation has been created! :D",HttpStatus.CREATED);
	}
}
