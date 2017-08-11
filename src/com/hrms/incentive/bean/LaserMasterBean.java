package com.hrms.incentive.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laser_master_tbl")
public class LaserMasterBean {

	private int laser_master_id;
	private String laser_source;
	
	public LaserMasterBean() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public LaserMasterBean(int laser_master_id, String laser_source) {
		super();
		this.laser_master_id = laser_master_id;
		this.laser_source = laser_source;
	}


/**
	 * @param laser_source
	 */
	public LaserMasterBean(String laser_source) {
		super();
		this.laser_source = laser_source;
	}




	@Id 
    @Column(name="laser_master_id")
    @GeneratedValue
	public int getLaser_master_id() {
		return laser_master_id;
	}

	public void setLaser_master_id(int laser_master_id) {
		this.laser_master_id = laser_master_id;
	}

	@Column(name="laser_source")
	public String getLaser_source() {
		return laser_source;
	}

	public void setLaser_source(String laser_source) {
		this.laser_source = laser_source;
	}
	
	
	
}
