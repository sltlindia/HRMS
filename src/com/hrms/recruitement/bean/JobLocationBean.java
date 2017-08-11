package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_location_tbl")
public class JobLocationBean implements Serializable
{

	
    private int job_location_id;
    private String job_location_name;
    
    public JobLocationBean() {
		// TODO Auto-generated constructor stub
	}
    
    
    @Id 
	@Column(name="job_location_id")
	@GeneratedValue
	public int getJob_location_id() {
		return job_location_id;
	}
	public void setJob_location_id(int job_location_id) {
		this.job_location_id = job_location_id;
	}
	@Column(name="job_location_name")
	public String getJob_location_name() {
		return job_location_name;
	}
	public void setJob_location_name(String job_location_name) {
		this.job_location_name = job_location_name;
	}
	
    
}
    