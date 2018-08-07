package com.visa.service;

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

	@Transactional
	public void addReservation(Reservation r) {
		reservationDao.save(r);
	}

	@Transactional
	public void updateReservation(int id, Reservation r) {
		Reservation rr = reservationDao.getOne(id);
		if (r.getfName() != null) {
			rr.setfName(r.getfName());
		}
		if (r.getlName() != null) {
			rr.setlName(r.getlName());
		}
		if (r.getStatus() != null) {
			rr.setStatus(r.getStatus());
		}

	}
	
	public List <Voucher> getAllVouchers() {
		return voucherDao.findAll();
	}
	
	public void addVoucher(Voucher v) {
		voucherDao.save(v);
	}
	
	public void updateVoucher(int id, Voucher v) {
		Voucher vv=voucherDao.getOne(id);
		vv.setVoucherCode(v.getVoucherCode());
		vv.setValid(v.isValid());
	}
	
	public List<RestaurantTiming> getRestaurantTime(){
		return restaurantTimingDao.findAll();
	}
	
	public void updateWorkingTimes(String dayOfWeek,RestaurantTiming rt) {
//		RestaurantTiming rtt=restaurantTimingDao.getOne(rt.getDayOfWeek());
	}

	public List<RestaurantTable> getTables() {
		return null;
	}

	public void addTable(RestaurantTable restaurantTable) {
		// TODO Auto-generated method stub
		
	}

	public void updateTable(String tid, RestaurantTable restaurantTable) {
		// TODO Auto-generated method stub
		
	}

	public void updateReservation(String reservation_id, Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	public List<RestaurantTiming> getRestaurantTimings() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addRestaurantTiming(RestaurantTiming restaurantTiming) {
		// TODO Auto-generated method stub
		
	}

	public void updateRestaurantTiming(String tid, RestaurantTiming restaurantTiming) {
		// TODO Auto-generated method stub
		
	}

	public void updateVoucher(String vid, Voucher voucher) {
		// TODO Auto-generated method stub
		
	}

}
