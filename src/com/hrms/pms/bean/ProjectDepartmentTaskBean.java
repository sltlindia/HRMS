package com.hrms.pms.bean;

import java.io.Serializable;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

@Entity
@Table(name="project_department_task_tbl")
public class ProjectDepartmentTaskBean implements Serializable{

	private int project_department_task_id;
	private int task_master_id;
	private int milestone_id;
	
	
	private ManagerBean managerBean;
	private ProjectMasterBean projectMasterBean;
	
	public ProjectDepartmentTaskBean() {
		// TODO Auto-generated constructor stub
	}


	
	
	public ProjectDepartmentTaskBean(int task_master_id, int milestone_id, ManagerBean managerBean,ProjectMasterBean projectMasterBean) {
		super();
		this.task_master_id = task_master_id;
		this.milestone_id = milestone_id;
		this.managerBean = managerBean;
		this.projectMasterBean = projectMasterBean;
	}




	@Id
	@Column(name="project_department_task_id")
	@GeneratedValue
	public int getProject_department_task_id() {
		return project_department_task_id;
	}


	public void setProject_department_task_id(int project_department_task_id) {
		this.project_department_task_id = project_department_task_id;
	}


	@Column(name="task_master_id")
	public int getTask_master_id() {
		return task_master_id;
	}


	public void setTask_master_id(int task_master_id) {
		this.task_master_id = task_master_id;
	}


	@Column(name="milestone_id")
	public int getMilestone_id() {
		return milestone_id;
	}


	public void setMilestone_id(int milestone_id) {
		this.milestone_id = milestone_id;
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
	@JoinColumn(name="manager_id")
	public ManagerBean getManagerBean() {
		return managerBean;
	}
	public void setManagerBean(ManagerBean managerBean) {
		this.managerBean = managerBean;
	}
	
	
	
	
	
	
	
}
