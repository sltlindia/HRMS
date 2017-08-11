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
@Table(name="specific_criteria_Allocation_tbl")
public class SpecificCriteriaBean implements Serializable {

	@Id @GeneratedValue
	private int specific_criteria_allocation_id;
	private int under_manager_id;
	private int technical_per;
	private int softskill_per;
	private int under_dept_id;
	
	private ProjectMasterBean projectMasterBean;
	private EmployeeBean employeeBean;
	
	public SpecificCriteriaBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SpecificCriteriaBean(EmployeeBean employeeBean,ProjectMasterBean projectMasterBean,int under_manager_id,int technical_per,int softskill_per,int under_dept_id) {

	this.employeeBean = employeeBean;
	this.projectMasterBean = projectMasterBean;
	this.under_dept_id = under_dept_id;
	this.under_manager_id = under_manager_id;
	this.technical_per = technical_per;
	this.softskill_per = softskill_per;
	
	
	}
	
	@Id 
	@Column(name="specific_criteria_allocation_id")
	@GeneratedValue
	public int getSpecific_criteria_allocation_id() {
		return specific_criteria_allocation_id;
	}
	public void setSpecific_criteria_allocation_id(int specific_criteria_allocation_id) {
		this.specific_criteria_allocation_id = specific_criteria_allocation_id;
	}
	
	@Column(name="under_manager_id")
	public int getUnder_manager_id() {
		return under_manager_id;
	}
	public void setUnder_manager_id(int under_manager_id) {
		this.under_manager_id = under_manager_id;
	}
	
	@Column(name="technical_per")
	public int getTechnical_per() {
		return technical_per;
	}
	public void setTechnical_per(int technical_per) {
		this.technical_per = technical_per;
	}
	
	@Column(name="softskill_per")
	public int getSoftskill_per() {
		return softskill_per;
	}
	public void setSoftskill_per(int softskill_per) {
		this.softskill_per = softskill_per;
	}
	
	@Column(name="under_dept_id")
	public int getUnder_dept_id() {
		return under_dept_id;
	}
	public void setUnder_dept_id(int under_dept_id) {
		this.under_dept_id = under_dept_id;
	}
	
	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}
	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
	
	
	
}
