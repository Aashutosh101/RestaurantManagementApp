package com.visa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.dao.ReservationDao;
import com.visa.dao.RestaurantTableDao;
import com.visa.dao.RestaurantTimingDao;
import com.visa.dao.UserDao;
import com.visa.dao.VoucherDao;
import com.visa.entity.Reservation;
import com.visa.entity.RestaurantTable;
import com.visa.entity.RestaurantTiming;
import com.visa.entity.User;
import com.visa.entity.Voucher;

@Service
public class AdminService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RestaurantTableDao restaurantTableDao;

	@Autowired
	private RestaurantTimingDao restaurantTimingDao;

	@Autowired
	private VoucherDao voucherDao;

	@Autowired
	private ReservationDao reservationDao;

	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Transactional
	public void addUser(User u) {
		userDao.save(u);
	}

	@Transactional
	public void updateUser(String email, User u) {
		User user = userDao.getOne(email);
		user.setEmail(u.getEmail());
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setPassword(u.getPassword());
		user.setPhone(u.getPhone());
		user.setRegistrationDate(u.getRegistrationDate());
		user.setStatus(u.getStatus());
	}

	public List<Reservation> getAllReservations() {
		return reservationDao.findAll();
	}
	
	public List<Reservation> getReservationByDate(Date date){

		Date temporary=new Date(date.getYear(),date.getMonth(),date.getDate(),0,0,0);
		Date nextDate=new Date(temporary.getTime()+1000*24*60*60);
		return reservationDao.findByDate(date,nextDate);
		
	}
	
	public List<Reservation> getReservationToday(){
		Date date=new Date();
		Date temporary=new Date(date.getYear(),date.getMonth(),date.getDate(),0,0,0);
		Date nextDate=new Date(temporary.getTime()+1000*24*60*60);
		return reservationDao.findByDate(date,nextDate);
	}
	
	public List<Reservation> getReservationTomorrow(){
		Date date=new Date();
		Date temporary=new Date(date.getYear(),date.getMonth(),date.getDate(),0,0,0);
		Date tomorrow=new Date(temporary.getTime()+1000*24*60*60);
		Date afterTomorrow=new Date(tomorrow.getTime()+1000*24*60*60);
		System.out.println(tomorrow);
		System.out.println(afterTomorrow);
		return reservationDao.findByDate(tomorrow,afterTomorrow);
	}
	
	@Transactional
	public void addReservation(Reservation r) {
		reservationDao.save(r);
	}

	@Transactional
	public void updateReservation(int id, Reservation r) {
		Reservation rr = reservationDao.getOne(id);
		rr.setfName(r.getfName());
		rr.setlName(r.getlName());
		rr.setStatus(r.getStatus());
	}

	public List<Voucher> getAllVouchers() {
		return voucherDao.findAll();
	}

	@Transactional
	public void addVoucher(Voucher v) {
		voucherDao.save(v);
	}

	@Transactional
	public void updateVoucher(int id, Voucher v) {
		Voucher vv = voucherDao.getOne(id);
		vv.setVoucherCode(v.getVoucherCode());
		vv.setValid(v.isValid());
	}

	public List<RestaurantTiming> getRestaurantTime() {
		return restaurantTimingDao.findAll();
	}

	@Transactional
	public void updateRestaurantTime(int dayOfWeek, RestaurantTiming rt) {
		RestaurantTiming rtt = restaurantTimingDao.getOne(rt.getDayOfWeek());
		rtt.setStartTime(rt.getStartTime());
		rtt.setEndTime(rt.getEndTime());
		rtt.setDayOff(rt.isDayOff());
		rtt.setAddedBy(rt.getAddedBy());
		////
	}

	public List<RestaurantTable> getTables() {
		return restaurantTableDao.findAll();
	}

	@Transactional
	public void addTable(RestaurantTable t) {
		restaurantTableDao.save(t);
	}

	@Transactional
	public void addRestaurantTime(RestaurantTiming restaurantTiming) {
		restaurantTimingDao.save(restaurantTiming);
		
	}
	
	public Voucher validateVoucher(String voucherCode) {
		return voucherDao.findByVoucherCode(voucherCode);
				
	}
}