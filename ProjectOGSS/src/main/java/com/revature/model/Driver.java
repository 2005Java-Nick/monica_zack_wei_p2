package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "delivery_driver_status")
public class Driver {
	@Id
	private int id;

	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	@JoinColumn(name = "user_account_id")
	@JsonIgnore
	UserAccount driver;

	@Column(name = "on_shift")
	Boolean onShift;

	public Driver(UserAccount driver, Boolean onShift) {
		super();
		this.driver = driver;
		this.onShift = onShift;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccount getDriver() {
		return driver;
	}

	public void setDriver(UserAccount driver) {
		this.driver = driver;
	}

	public Boolean getOnShift() {
		return onShift;
	}

	public void setOnShift(Boolean onShift) {
		this.onShift = onShift;
	}
}
