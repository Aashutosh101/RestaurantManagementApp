package com.visa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vouchers")
public class Voucher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="voucher_id")
	private int voucherId;
	
	@ManyToOne
	@JoinColumn(name="added_by_fk")
	private User user;
	
	@Column(name="voucher_code")
	private String voucherCode;
	
	@Column(name="is_valid")
	private boolean isValid;
	
	@OneToOne(mappedBy="voucher")
	private Reservation reservation;

	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public Voucher() {
	}
	

	
	public Voucher(int voucherId, User user, String voucherCode, boolean isValid, Reservation reservation) {
		this.voucherId = voucherId;
		this.user = user;
		this.voucherCode = voucherCode;
		this.isValid = isValid;
		this.reservation = reservation;
	}


	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}


	public boolean isValid() {
		return isValid;
	}


	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
