package com.hrms.riskmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="severity_tbl")
public class SeverityBean implements Serializable {

	
	private int severity_id;
	private String severity_name;
	
	@Id
	@Column(name="severity_id")
    @GeneratedValue
	public int getSeverity_id() {
		return severity_id;
	}
	public void setSeverity_id(int severity_id) {
		this.severity_id = severity_id;
	}
	@Column(name="severity_name")
	public String getSeverity_name() {
		return severity_name;
	}
	public void setSeverity_name(String severity_name) {
		this.severity_name = severity_name;
	}
	
	
}
