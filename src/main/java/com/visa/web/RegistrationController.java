package com.visa.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.entity.Reservation;
import com.visa.entity.RestaurantTable;
import com.visa.entity.User;
import com.visa.entity.Voucher;
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
	/*
	@RequestMapping(value="api/users/register/checkout", method=RequestMethod.POST)
	public ResponseEntity<String> checkout(@RequestBody Map<String,Object> payload) throws RestaurantApiException{
		System.out.println(payload);
		Reservation r= new Reservation();
		Date reservedFrom;
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		try {
			reservedFrom = datetimeFormatter.parse(payload.get("date")+" "+payload.get("time"));
			r.setReservedFrom(reservedFrom);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RestaurantApiException(payload.get("date")+" "+payload.get("time"),  e.getMessage(), e);
		}
		r.setEmail((String) payload.get("email"));
		r.setfName((String) payload.get("fname"));
		r.setlName((String) payload.get("lname"));
		r.setNoOfPeople((int) payload.get("noOfPeople"));
		r.setPhone((String) payload.get("phone"));
		/*
		RestaurantTable rTable = new RestaurantTable();
		rTable.setId((int) payload.get("rTable"));
		r.setrTable(rTable);
		
		r.setStatus((String) payload.get("status"));
		r.setTitle((String) payload.get("title"));
		
		User user= new User();
		user.setEmail((String) payload.get("user.email"));
		r.setUser(user);
		
		if(payload.get("voucher")!=null) {
			Voucher voucher=new Voucher();
			voucher.setVoucherId((int) payload.get("voucher.id"));
			r.setVoucher(voucher);
		}
		
		System.out.println(r);
		return new ResponseEntity<String>("Your reservation has been created :D", HttpStatus.CREATED);
	}
	*/
	
	@RequestMapping(value="api/users/register/checkout", method=RequestMethod.POST)
	public ResponseEntity<String> checkout(@RequestBody Reservation r) throws RestaurantApiException{
		userService.checkout(r);
		return new ResponseEntity<String>("Your reservation has been created :D", HttpStatus.CREATED);
	}
}
