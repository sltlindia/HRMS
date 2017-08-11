package com.hrms.riskmanagement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monitoring_frequency_tbl")
public class MonitoringFrequencyBean {
	 private int monitoring_frequency_id;
	 private String monitoring_frequency_name;
	 
	 
	 
	public MonitoringFrequencyBean(int monitoring_frequency_id, String monitoring_frequency_name) {
		this.monitoring_frequency_id = monitoring_frequency_id;
		this.monitoring_frequency_name = monitoring_frequency_name;
	}
	public MonitoringFrequencyBean() {
	}
	
	
	
	@Id
	@Column(name="monitoring_frequency_id")
    @GeneratedValue
	public int getMonitoring_frequency_id() {
		return monitoring_frequency_id;
	}
	public void setMonitoring_frequency_id(int monitoring_frequency_id) {
		this.monitoring_frequency_id = monitoring_frequency_id;
	}
	
	@Column(name="monitoring_frequency_name")
	public String getMonitoring_frequency_name() {
		return monitoring_frequency_name;
	}
	public void setMonitoring_frequency_name(String monitoring_frequency_name) {
		this.monitoring_frequency_name = monitoring_frequency_name;
	}
	 

}
