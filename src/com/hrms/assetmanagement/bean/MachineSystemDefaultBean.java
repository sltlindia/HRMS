package com.hrms.assetmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="machine_system_default_tbl")
public class MachineSystemDefaultBean implements Serializable{
	
	private int machine_system_default_id;
	private String description;
	
	public MachineSystemDefaultBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Id 
	@Column(name="machine_system_default_id")
	@GeneratedValue
	public int getMachine_system_default_id() {
		return machine_system_default_id;
	}

	public void setMachine_system_default_id(int machine_system_default_id) {
		this.machine_system_default_id = machine_system_default_id;
	}

	
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
