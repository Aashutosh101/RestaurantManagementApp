package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.prj.entity.RestaurantTiming;

@Repository
public interface RestaurantTimingDao extends JpaRepository<RestaurantTiming, String> {

}
