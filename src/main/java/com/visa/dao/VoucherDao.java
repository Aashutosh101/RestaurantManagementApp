package com.visa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.entity.Voucher;

@Repository
public interface VoucherDao extends JpaRepository<Voucher, Integer> {

}
