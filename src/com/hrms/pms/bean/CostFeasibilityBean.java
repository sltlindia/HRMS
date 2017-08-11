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
@Table(name="cost_feasibility_tbl")
public class CostFeasibilityBean implements Serializable{
	
	private int cost_feasibility_id;
	private String  cost_feasibility_name;
	private String remarks;
	
	private ProjectMasterBean projectMasterBean;
	
	public CostFeasibilityBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CostFeasibilityBean(int cost_feasibility_id, String cost_feasibility_name, String remarks,
			ProjectMasterBean projectMasterBean) {
		super();
		this.cost_feasibility_id = cost_feasibility_id;
		this.cost_feasibility_name = cost_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}



	public CostFeasibilityBean(String cost_feasibility_name, String remarks, ProjectMasterBean projectMasterBean) {
		super();
		this.cost_feasibility_name = cost_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}



	@Id
	@Column(name="cost_feasibility_id")
    @GeneratedValue
	public int getCost_feasibility_id() {
		return cost_feasibility_id;
	}

	public void setCost_feasibility_id(int cost_feasibility_id) {
		this.cost_feasibility_id = cost_feasibility_id;
	}

	public String getCost_feasibility_name() {
		return cost_feasibility_name;
	}

	public void setCost_feasibility_name(String cost_feasibility_name) {
		this.cost_feasibility_name = cost_feasibility_name;
	}

	
	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}

	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	

}
