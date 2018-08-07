package com.visa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reservationId;
	
	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;
	
	@OneToOne
	@JoinColumn(name="table_fk")
	private RestaurantTable rTable;
	
	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="reserved_from")
	private Date reservedFrom;

	
	private String status;
	
	private String title;
	
	private String fName;
	private String lName;
	private String email;
	private String phone;
	
	@OneToOne
	@JoinColumn(name="voucher_fk")
	private Voucher voucher;
	
	private int noOfPeople;

	public Reservation() {
	}

	public Reservation(int reservationId, User user, RestaurantTable rTable, Date reserved_from, 
			String status, String title, String fName, String lName, String email, String phone, Voucher voucher,
			int noOfPeople) {
		this.reservationId = reservationId;
		this.user = user;
		this.rTable = rTable;

		this.reservedFrom = reserved_from;

		this.status = status;
		this.title = title;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
		this.voucher = voucher;
		this.noOfPeople = noOfPeople;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RestaurantTable getrTable() {
		return rTable;
	}

	public void setrTable(RestaurantTable rTable) {
		this.rTable = rTable;
	}


	public Date getReservedFrom() {
		return reservedFrom;
	}

	public void setReservedFrom(Date reserved_from) {
		this.reservedFrom = reserved_from;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	
	
}
