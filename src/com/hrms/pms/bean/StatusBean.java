package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status_tbl")
public class StatusBean implements Serializable{


	private int status_id;
	private String status_name;
	
	public StatusBean() {
	
	}

	@Id 
	@Column(name="status_id")
	@GeneratedValue
	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	@Column(name="status_name")
	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
}
