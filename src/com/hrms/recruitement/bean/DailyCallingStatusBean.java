package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="daily_calling_status_tbl")
public class DailyCallingStatusBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DailyCallingStatusBean(){}
	
	private int daily_calling_status_id;
	private String daily_calling_status_name;

	@Id
	@GeneratedValue
	@Column(name="daily_calling_status_id")
	public int getDaily_calling_status_id() {
		return daily_calling_status_id;
	}
	public void setDaily_calling_status_id(int daily_calling_status_id) {
		this.daily_calling_status_id = daily_calling_status_id;
	}
	public String getDaily_calling_status_name() {
		return daily_calling_status_name;
	}
	public void setDaily_calling_status_name(String daily_calling_status_name) {
		this.daily_calling_status_name = daily_calling_status_name;
	}
	
	

}
