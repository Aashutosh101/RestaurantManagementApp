package com.visa.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.entity.Reservation;
import com.visa.entity.User;
import com.visa.service.AdminService;
import com.visa.service.UserService;

@RestController
public class ReservationController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="api/admin/reservations", method=RequestMethod.GET)
	public @ResponseBody List<Reservation> getAllReservations() {
		List<Reservation> r= adminService.getAllReservations();
		return r;
	}

	@RequestMapping(value="api/admin/reservations/{reservation_id}", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> updateRestaurantTable(@PathVariable("reservation_id") String reservation_id, @RequestBody Reservation reservation){
		adminService.updateReservation(Integer.parseInt(reservation_id), reservation);
		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/reservations/{date}/{time}", method=RequestMethod.GET)
	public @ResponseBody List<Reservation> getReservationsByDate(@PathVariable("date") String date,@PathVariable("time") String time) throws RestaurantApiException {
		SimpleDateFormat datetimeFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date fromDate;
		try {
			fromDate = datetimeFormatter.parse(date+" "+time);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RestaurantApiException(date+" "+time,  e.getMessage(), e);
		}
		List<Reservation> r= adminService.getReservationByDate(fromDate);
		return r;
	}
	
	@RequestMapping(value="api/admin/reservations/today", method=RequestMethod.GET)
	public @ResponseBody List<Reservation> getReservationsToday(){
		return adminService.getReservationToday();
	}
	

	@RequestMapping(value="api/admin/reservations/tomorrow", method=RequestMethod.GET)
	public @ResponseBody List<Reservation> getReservationsTomorrow(){
		return adminService.getReservationTomorrow();
	}
	

	@RequestMapping(value="api/users/reservations/{email}",method=RequestMethod.GET)
	public @ResponseBody List<Reservation> getReservations(@PathVariable("email") String email){
		User u = userService.getById(email);
		return  userService.getAllReservations(u);
	}
}
