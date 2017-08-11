package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="quarterly_month_tbl")
public class QuterlyMonthBean implements Serializable {
	
	private int quarterly_month_id;
	private String quarterly_month_name;
	private String month_duration;
	
	
	
	@Id
	@Column(name="quarterly_month_id")
    @GeneratedValue
	public int getQuarterly_month_id() {
		return quarterly_month_id;
	}
	public void setQuarterly_month_id(int quarterly_month_id) {
		this.quarterly_month_id = quarterly_month_id;
	}
	
	@Column(name="quarterly_month_name")
	public String getQuarterly_month_name() {
		return quarterly_month_name;
	}
	public void setQuarterly_month_name(String quarterly_month_name) {
		this.quarterly_month_name = quarterly_month_name;
	}
	
	@Column(name="month_duration")
	public String getMonth_duration() {
		return month_duration;
	}
	public void setMonth_duration(String month_duration) {
		this.month_duration = month_duration;
	}
	
	
	
	
}
