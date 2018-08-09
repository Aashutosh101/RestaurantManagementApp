package com.visa.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_tables")
public class RestaurantTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private int capacity;
	
	public RestaurantTable() {
	}

	public RestaurantTable(int id, int capacity) {
		super();

		this.id = id;
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

	@Override
	public String toString() {
		return "RestaurantTable [id=" + id + ", capacity=" + capacity + "]";
	}	
	
	
}
