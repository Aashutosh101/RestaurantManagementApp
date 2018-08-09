package com.visa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

}
