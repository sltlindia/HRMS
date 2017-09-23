package com.hrms.vehicletracking.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="driver_tbl")
public class DriverBean implements Serializable {
	
	
	private int driver_id;
	private String driver_first_name;
	private String driver_last_name;
	
	
	
	
	
	@Id
	@GeneratedValue
	@Column(name="driver_id")
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	
	@Column(name="driver_first_name")
	public String getDriver_first_name() {
		return driver_first_name;
	}
	public void setDriver_first_name(String driver_first_name) {
		this.driver_first_name = driver_first_name;
	}
	
	@Column(name="driver_last_name")
	public String getDriver_last_name() {
		return driver_last_name;
	}
	public void setDriver_last_name(String driver_last_name) {
		this.driver_last_name = driver_last_name;
	}
	
	
	

}
