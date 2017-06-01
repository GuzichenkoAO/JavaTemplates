package com.guzichenko.templates.hibernate.basic.entities;

import java.util.Date;

public class MappedEvent {
	private Long id;

	private String title;
	private Date date;

	public MappedEvent() {
		// this form used by Hibernate
	}

	public MappedEvent(String title, Date date) {
		// for application use, to create new events
		this.title = title;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}