package com.visa.prj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_tables")
public class RestaurantTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(mappedBy="rTable")
	private Reservation reservation;
	
	
	private int capacity;
	
	public RestaurantTable() {
	}

	

	
	public RestaurantTable(int id, int capacity) {
		super();

		this.id = id;
		this.reservation = reservation;
		this.capacity = capacity;
	}




	
	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	
}
