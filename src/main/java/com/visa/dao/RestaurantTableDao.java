package com.visa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.visa.entity.Reservation;
import com.visa.entity.RestaurantTable;

@Repository
public interface RestaurantTableDao extends JpaRepository<RestaurantTable, Integer> {

}
