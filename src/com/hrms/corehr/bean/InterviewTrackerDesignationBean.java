package com.hrms.corehr.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interview_tracker_designation_tbl")
public class InterviewTrackerDesignationBean implements Serializable{
	
	private int interview_role_id;
	private String interview_role_type;
	private String interview_role_authority;
	private String interview_level;
	private String interview_level_name;
	

	
	
	
	
	public InterviewTrackerDesignationBean(int interview_role_id, String interview_role_type,
			String interview_role_authority, String interview_level, String interview_level_name) {
		super();
		this.interview_role_id = interview_role_id;
		this.interview_role_type = interview_role_type;
		this.interview_role_authority = interview_role_authority;
		this.interview_level = interview_level;
		this.interview_level_name = interview_level_name;
	}
	
	public InterviewTrackerDesignationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id 
    @Column(name="interview_role_id")
    @GeneratedValue
	public int getInterview_role_id() {
		return interview_role_id;
	}
	public void setInterview_role_id(int interview_role_id) {
		this.interview_role_id = interview_role_id;
	}
	public String getInterview_role_type() {
		return interview_role_type;
	}
	public void setInterview_role_type(String interview_role_type) {
		this.interview_role_type = interview_role_type;
	}
	public String getInterview_role_authority() {
		return interview_role_authority;
	}
	public void setInterview_role_authority(String interview_role_authority) {
		this.interview_role_authority = interview_role_authority;
	}
	public String getInterview_level() {
		return interview_level;
	}
	public void setInterview_level(String interview_level) {
		this.interview_level = interview_level;
	}
	public String getInterview_level_name() {
		return interview_level_name;
	}
	public void setInterview_level_name(String interview_level_name) {
		this.interview_level_name = interview_level_name;
	}
	
	
	
}
