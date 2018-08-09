package com.visa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="restaurant_tables")
public class RestaurantTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
//	@OneToMany(mappedBy="rTable", fetch=FetchType.LAZY)
	@Transient
	private List<Reservation> reservations;
	
	
	private int capacity;
	
	public RestaurantTable() {
	}

	

	
	public RestaurantTable(int id, int capacity,List<Reservation> reservations) {
		super();

		this.id = id;
		this.reservations = reservations;
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
	
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
}
