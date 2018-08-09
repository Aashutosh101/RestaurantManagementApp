package com.visa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "restaurant_timing")
public class RestaurantTiming {

	@Id
	private int dayOfWeek;
	
//	@Temporal(TemporalType.TIME)
	@Column(name="start_time")
	private String startTime;
	
//	@Temporal(TemporalType.TIME)
	@Column(name="end_time")
	private String endTime;
	
	@ManyToOne
	@JoinColumn(name="added_by_fk")
	private User addedBy;
	
	@Column(name="is_day_off")
	private boolean isDayOff;
	
	public RestaurantTiming() {
	}

	public RestaurantTiming(int dayOfWeek, String startTime, String endTime, User addedBy, boolean isDayOff) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.addedBy = addedBy;
		this.isDayOff = isDayOff;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public boolean isDayOff() {
		return isDayOff;
	}

	public void setDayOff(boolean isDayOff) {
		this.isDayOff = isDayOff;
	}

	
}
