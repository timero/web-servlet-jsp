package com.epam.training.sprinkler.domain;

import java.util.Date;

public class ScheduledItem {

	private int id;
	private Date from;
	private Date to;
	private Zone zone;
	private boolean recurring;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFrom() {
		return new Date(from.getTime());
	}

	public void setFrom(Date from) {
		this.from = new Date(from.getTime());
	}

	public Date getTo() {
		return new Date(to.getTime());
	}

	public void setTo(Date to) {
		this.to = new Date(to.getTime());
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

}
