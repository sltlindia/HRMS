package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_manager_list_tbl")
public class ProjectManagerListBean implements Serializable{
	
	private int project_manager_list_id;
	
	private String description;
	private String start_date;
	private String end_date;
	
	private EmployeeBean employeeBean;
	private ProjectMasterBean projectMasterBean;
	
	
	
	public ProjectManagerListBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ProjectManagerListBean(EmployeeBean employeeBean, ProjectMasterBean projectMasterBean) {
		super();
		this.employeeBean = employeeBean;
		this.projectMasterBean = projectMasterBean;
	}
	
	
	@Id
    @Column(name="project_manager_list_id")
    @GeneratedValue
	public int getProject_manager_list_id() {
		return project_manager_list_id;
	}
	public void setProject_manager_list_id(int project_manager_list_id) {
		this.project_manager_list_id = project_manager_list_id;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}
	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStart_date() {
		return start_date;
	}



	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}



	public String getEnd_date() {
		return end_date;
	}



	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	
	
	

}
