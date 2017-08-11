package com.hrms.riskmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="risk_status_tbl")
public class RiskStatusBean implements Serializable {
	
	
	private int risk_status_id;
	private String risk_status_name;
	@Id
	@Column(name="risk_status_id")
    @GeneratedValue
	public int getRisk_status_id() {
		return risk_status_id;
	}
	public void setRisk_status_id(int risk_status_id) {
		this.risk_status_id = risk_status_id;
	}
	@Column(name="risk_status_name")
	public String getRisk_status_name() {
		return risk_status_name;
	}
	public void setRisk_status_name(String risk_status_name) {
		this.risk_status_name = risk_status_name;
	}
	
	
}
