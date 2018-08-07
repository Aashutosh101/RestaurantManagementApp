package com.visa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="restaurant_timing")
public class RestaurantTiming {

	@Id
	private String dayOfWeek;
	
	@Temporal(TemporalType.TIME)
	@Column(name="start_time")
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name="end_time")
	private Date endTime;
	
	@ManyToOne
	@JoinColumn(name="added_by_fk")
	private User addedBy;
	
	@Column(name="is_day_off")
	private boolean isDayOff;
	
	public RestaurantTiming() {
	}

	public RestaurantTiming(String dayOfWeek, Date startTime, Date endTime, User addedBy, boolean isDayOff) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.addedBy = addedBy;
		this.isDayOff = isDayOff;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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
