package com.hrms.assetmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="machine_check_points_default_tbl")
public class MachineCheckPointsDefaultBean implements Serializable{

	private int machine_check_points_default_id;
	private String description;
	
	public MachineCheckPointsDefaultBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Id 
	@Column(name="machine_check_points_default_id")
	@GeneratedValue
	public int getMachine_check_points_default_id() {
		return machine_check_points_default_id;
	}

	public void setMachine_check_points_default_id(int machine_check_points_default_id) {
		this.machine_check_points_default_id = machine_check_points_default_id;
	}

	
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
