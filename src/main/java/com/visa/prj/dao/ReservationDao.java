package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Reservation;
import com.visa.prj.entity.RestaurantTable;
import com.visa.prj.entity.User;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {

	@Query("SELECT r.rTable FROM  Reservation r, where r.date = :date AND r.status = 'Cancelled' OR  r.status = 'Enquiry'")
	public List<RestaurantTable> findReservedTables(@Param("date") Date date);
	
	public List<Reservation> findByUser(User user);
}
