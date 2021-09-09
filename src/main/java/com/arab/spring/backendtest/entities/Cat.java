package com.arab.spring.backendtest.entities;

import java.sql.Timestamp;

public class Cat {

	private Long id;
	private String cat_name;
	private Timestamp time_fed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public Timestamp getTime_fed() {
		return time_fed;
	}

	public void setTime_fed(Timestamp time_fed) {
		this.time_fed = time_fed;
	}
}
