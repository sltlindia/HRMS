package com.hrms.lms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gate_location_tbl")
public class GateLoationBean implements Serializable{

	private int gate_location_id;
	private String gate_location_name;
	
	@Id 
    @Column(name="gate_location_id")
    @GeneratedValue
	public int getGate_location_id() {
		return gate_location_id;
	}
	public void setGate_location_id(int gate_location_id) {
		this.gate_location_id = gate_location_id;
	}
	
	@Column(name="gate_location_name")
	public String getGate_location_name() {
		return gate_location_name;
	}
	public void setGate_location_name(String gate_location_name) {
		this.gate_location_name = gate_location_name;
	}
	
	
	
}
