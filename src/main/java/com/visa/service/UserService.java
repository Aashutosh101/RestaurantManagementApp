package com.visa.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.dao.ReservationDao;
import com.visa.dao.RestaurantTableDao;
import com.visa.dao.RestaurantTimingDao;
import com.visa.dao.UserDao;
import com.visa.entity.Reservation;
import com.visa.entity.RestaurantTable;
import com.visa.entity.RestaurantTiming;
import com.visa.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RestaurantTableDao restaurantTableDao;
	
	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private RestaurantTimingDao restaurantTimingDao;
	
	
	public List<RestaurantTable> checkAvailability(Date date, int noOfPeople) {
		List<RestaurantTable> reservedTables=reservationDao.findReservedTables(date);
		List<RestaurantTable> allTables=restaurantTableDao.findAll();
		List<RestaurantTable> availableTables=allTables.stream().filter(t -> (!reservedTables.contains(t)) && t.getCapacity()>=noOfPeople && t.getCapacity() <= noOfPeople+2 ).collect(Collectors.toList());
		return availableTables;		
	}
	
	public List<Reservation> getAllReservations(User u){
		return reservationDao.findByUser(u);
	}
	
	@Transactional
	public void checkout(Reservation reservation) {
		reservationDao.save(reservation);
	}

	public boolean checkIfUserExist(String email, String password) {
		return false;
	}

	public boolean checkIfAdminExist(String email, String password) {
		return false;
	}
	
	public User getById(String email) {
		return userDao.findById(email).get();
	}
	
	public RestaurantTiming getRestaurantTimingByDay(int i) {
		return restaurantTimingDao.findByDayOfWeek(i);
	}
}
