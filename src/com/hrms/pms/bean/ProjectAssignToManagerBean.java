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
@Table(name="project_assign_to_manager_tbl")
public class ProjectAssignToManagerBean implements Serializable {
	
	private int project_assign_to_manager_id;
	private int creator_manager_id;
	
	private ProjectMasterBean projectMasterBean;
	private EmployeeBean employeeBean;
	
	
	public ProjectAssignToManagerBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public ProjectAssignToManagerBean(int creator_manager_id, ProjectMasterBean projectMasterBean,
			EmployeeBean employeeBean) {
		super();
		this.creator_manager_id = creator_manager_id;
		this.projectMasterBean = projectMasterBean;
		this.employeeBean = employeeBean;
	}






	@Id
	@Column(name="project_assign_to_manager_id")
    @GeneratedValue
	public int getProject_assign_to_manager_id() {
		return project_assign_to_manager_id;
	}
	public void setProject_assign_to_manager_id(int project_assign_to_manager_id) {
		this.project_assign_to_manager_id = project_assign_to_manager_id;
	}
	
	@Column(name="creator_manager_id")
	public int getCreator_manager_id() {
		return creator_manager_id;
	}
	public void setCreator_manager_id(int creator_manager_id) {
		this.creator_manager_id = creator_manager_id;
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
