package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Voucher;

@Repository
public interface VoucherDao extends JpaRepository<Voucher, Integer> {

}
