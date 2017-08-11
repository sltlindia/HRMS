package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="month_tbl")
public class MonthBean implements Serializable
{

	
    private int month_id;
	private String month_name;
    
    
    public MonthBean() {
		// TODO Auto-generated constructor stub
    }

    @Id 
    @Column(name="month_id")
    @GeneratedValue
	public int getMonth_id() {
		return month_id;
	}


	public void setMonth_id(int month_id) {
		this.month_id = month_id;
	}

	@Column(name="month_name")
	public String getMonth_name() {
		return month_name;
	}


	public void setMonth_name(String month_name) {
		this.month_name = month_name;
	}
    
    
}
