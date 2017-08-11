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
@Table(name="milestone_tbl")
public class MilestoneBean implements Serializable {
	
	private int milestone_id;
	private String milestone_name;
	private String milestone_description;
	
	private ProjectMasterBean projectMasterBean;
	private PriorityBean priorityBean;
	private ManagerBean managerBean;
	
	
	@Id
	@Column(name="milestone_id")
	@GeneratedValue
	public int getMilestone_id() {
		return milestone_id;
	}
	public void setMilestone_id(int milestone_id) {
		this.milestone_id = milestone_id;
	}
	
	@Column(name="milestone_name")
	public String getMilestone_name() {
		return milestone_name;
	}
	public void setMilestone_name(String milestone_name) {
		this.milestone_name = milestone_name;
	}
	
	@Column(name="milestone_description")
	public String getMilestone_description() {
		return milestone_description;
	}
	public void setMilestone_description(String milestone_description) {
		this.milestone_description = milestone_description;
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
	@JoinColumn(name="priority_id")
	public PriorityBean getPriorityBean() {
		return priorityBean;
	}
	public void setPriorityBean(PriorityBean priorityBean) {
		this.priorityBean = priorityBean;
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
