package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project_status_tbl")
public class ProjectStatusBean implements Serializable{
	
	private int project_status_id;
	private String project_status_name;
	
	public ProjectStatusBean() {
		// TODO Auto-generated constructor stub
	}

	@Id 
	@Column(name="project_status_id")
	@GeneratedValue
	public int getProject_status_id() {
		return project_status_id;
	}

	public void setProject_status_id(int project_status_id) {
		this.project_status_id = project_status_id;
	}
	
	@Column(name="project_status_name")
	public String getProject_status_name() {
		return project_status_name;
	}

	public void setProject_status_name(String project_status_name) {
		this.project_status_name = project_status_name;
	}
	
	

}
