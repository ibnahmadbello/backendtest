package com.arab.spring.backendtest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Volunteer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String volunteer_name;
	private int number_fed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVolunteer_name() {
		return volunteer_name;
	}

	public void setVolunteer_name(String volunteer_name) {
		this.volunteer_name = volunteer_name;
	}

	public int getNumber_fed() {
		return number_fed;
	}

	public void setNumber_fed(int number_fed) {
		this.number_fed = number_fed;
	}

}
