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
@Table(name="project_allocation_percentage_tbl")
public class ProjectAllocationPercentageBean  implements Serializable{


	private int project_allocation_percentage_id;
	private double per_allocation;
	private String allocation_start_date;
	private String allocation_end_date;
	private int allocation_status;
	private double cost;
	
	private ProjectMasterBean projectMasterBean;
	private EmployeeBean employeeBean;
	
	 @Id
	 @Column(name="project_allocation_percentage_id")
	 @GeneratedValue
	public int getProject_allocation_percentage_id() {
		return project_allocation_percentage_id;
	}
	public void setProject_allocation_percentage_id(int project_allocation_percentage_id) {
		this.project_allocation_percentage_id = project_allocation_percentage_id;
	}
	
	 @Column(name="per_allocation")
	public double getPer_allocation() {
		return per_allocation;
	}
	public void setPer_allocation(double per_allocation) {
		this.per_allocation = per_allocation;
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
	
	@Column(name="allocation_start_date")
	public String getAllocation_start_date() {
		return allocation_start_date;
	}
	public void setAllocation_start_date(String allocation_start_date) {
		this.allocation_start_date = allocation_start_date;
	}
	
	@Column(name="allocation_end_date")
	public String getAllocation_end_date() {
		return allocation_end_date;
	}
	public void setAllocation_end_date(String allocation_end_date) {
		this.allocation_end_date = allocation_end_date;
	}
	
	@Column(name="allocation_status")
	public int getAllocation_status() {
		return allocation_status;
	}
	public void setAllocation_status(int allocation_status) {
		this.allocation_status = allocation_status;
	}
	
	@Column(name="cost")
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
