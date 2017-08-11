package com.hrms.riskmanagement.bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="risk_priority_tbl")
public class RiskPriorityBean implements Serializable {
	
	
	private int risk_priority_id;
	private String risk_priority_name;
	
	
	@Id
	@Column(name="risk_priority_id")
    @GeneratedValue
    public int getRisk_priority_id() {
		return risk_priority_id;
	}

	public void setRisk_priority_id(int risk_priority_id) {
		this.risk_priority_id = risk_priority_id;
	}
	@Column(name="risk_priority_name")
	public String getRisk_priority_name() {
		return risk_priority_name;
	}
	public void setRisk_priority_name(String risk_priority_name) {
		this.risk_priority_name = risk_priority_name;
	}
	
	
	

}
