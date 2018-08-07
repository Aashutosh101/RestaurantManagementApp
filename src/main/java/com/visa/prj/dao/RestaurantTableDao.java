package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.prj.entity.RestaurantTable;

@Repository
public interface RestaurantTableDao extends JpaRepository<RestaurantTable, Integer> {

}
