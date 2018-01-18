package com.hrms.selfservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="software_nature_tbl")
public class SoftwareNatureBean implements Serializable {
	
	private int software_nature_id;
	private String software_nature_name;
	
	
	public SoftwareNatureBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SoftwareNatureBean(int software_nature_id, String software_nature_name) {
		super();
		this.software_nature_id = software_nature_id;
		this.software_nature_name = software_nature_name;
	}
	

	public SoftwareNatureBean(String software_nature_name) {
		super();
		this.software_nature_name = software_nature_name;
	}


	@Id
	@GeneratedValue
	@Column(name="software_nature_id")
	public int getSoftware_nature_id() {
		return software_nature_id;
	}


	public void setSoftware_nature_id(int software_nature_id) {
		this.software_nature_id = software_nature_id;
	}

	@Column(name="software_nature_name")
	public String getSoftware_nature_name() {
		return software_nature_name;
	}


	public void setSoftware_nature_name(String software_nature_name) {
		this.software_nature_name = software_nature_name;
	}
	

	
}
