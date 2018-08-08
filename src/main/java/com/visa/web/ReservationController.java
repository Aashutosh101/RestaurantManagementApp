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
	public @ResponseBody List<Reservation> getReservations() {
		return adminService.getAllReservations();
	}
	
	@RequestMapping(value="api/admin/reservations", method=RequestMethod.POST)
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
		adminService.addReservation(reservation);
		return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
	}

	@RequestMapping(value="api/admin/reservations/{reservation_id}", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> updateRestaurantTable(@PathVariable("reservation_id") String reservation_id, @RequestBody Reservation reservation){
		adminService.updateReservation(reservation_id, reservation);
		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="api/users/reservations",method=RequestMethod.GET)
	public @ResponseBody List<Reservation> getReservations(@PathVariable String email){
		User u = userService.getById(email);
		return  userService.getAllReservations(u);
	}
}
