package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="year_tbl")
public class YearBean implements Serializable
{

	
    private int year_id;
	private String year;
    
    
    public YearBean() {
		// TODO Auto-generated constructor stub
    }

    @Id 
    @Column(name="year_id")
    @GeneratedValue
	public int getYear_id() {
		return year_id;
	}


	public void setYear_id(int year_id) {
		this.year_id = year_id;
	}

	 @Column(name="year")
	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}
    
    
}
