package com.visa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.visa.entity.Reservation;
import com.visa.entity.RestaurantTable;
import com.visa.entity.User;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {

	@Query("SELECT r.rTable FROM  Reservation r where r.reservedFrom = :date AND r.status = 'Pending' OR  r.status = 'Confirmed'")
	public List<RestaurantTable> findReservedTables(@Param("date") Date date);
	
	public List<Reservation> findByUser(User user);
	
	@Query("FROM Reservation r where r.reservedFrom > :date AND r.reservedFrom< :nextDate")
	public List<Reservation> findByDate(@Param("date") Date date,@Param("nextDate") Date nextDate );
	
}
