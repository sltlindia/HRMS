package com.hrms.incentive.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zone_tbl")
public class ZoneBean {

	private int zone_id;
	private String zone_name;
	
	
	public ZoneBean(int zone_id, String zone_name) {
		super();
		this.zone_id = zone_id;
		this.zone_name = zone_name;
	}

	
	public ZoneBean() {
		super();
	}


	@Id 
    @Column(name="zone_id")
    @GeneratedValue
	public int getZone_id() {
		return zone_id;
	}


	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}

	@Column(name="zone_name")
	public String getZone_name() {
		return zone_name;
	}


	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	
	
	
	
}
