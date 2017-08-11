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
@Table(name="engineering_feasibility_tbl")
public class EngineeringFeasibilityBean implements Serializable {
	
	private int engineering_feasibility_id;
	private String  engineering_feasibility_name;
	private String remarks;
	
	private ProjectMasterBean projectMasterBean;
	
	
	public EngineeringFeasibilityBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public EngineeringFeasibilityBean(int engineering_feasibility_id, String engineering_feasibility_name,
			String remarks, ProjectMasterBean projectMasterBean) {
		super();
		this.engineering_feasibility_id = engineering_feasibility_id;
		this.engineering_feasibility_name = engineering_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}




	public EngineeringFeasibilityBean(String engineering_feasibility_name, String remarks,
			ProjectMasterBean projectMasterBean) {
		super();
		this.engineering_feasibility_name = engineering_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}




	@Id
	@Column(name="engineering_feasibility_id")
    @GeneratedValue
	public int getEngineering_feasibility_id() {
		return engineering_feasibility_id;
	}

	public void setEngineering_feasibility_id(int engineering_feasibility_id) {
		this.engineering_feasibility_id = engineering_feasibility_id;
	}

	public String getEngineering_feasibility_name() {
		return engineering_feasibility_name;
	}

	public void setEngineering_feasibility_name(String engineering_feasibility_name) {
		this.engineering_feasibility_name = engineering_feasibility_name;
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
