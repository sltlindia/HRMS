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
@Table(name="manufacturing_feasibility_tbl")
public class ManufacturingFeasibilityBean implements Serializable{
	
	private int manufacturing_feasibility_id;
	private String  manufacturing_feasibility_name;
	private String remarks;
	
	private ProjectMasterBean projectMasterBean;


	
	public ManufacturingFeasibilityBean() {
		// TODO Auto-generated constructor stub
	}
	

	

	public ManufacturingFeasibilityBean(int manufacturing_feasibility_id, String manufacturing_feasibility_name,
			String remarks, ProjectMasterBean projectMasterBean) {
		super();
		this.manufacturing_feasibility_id = manufacturing_feasibility_id;
		this.manufacturing_feasibility_name = manufacturing_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}




	public ManufacturingFeasibilityBean(String manufacturing_feasibility_name, String remarks,
			ProjectMasterBean projectMasterBean) {
		super();
		this.manufacturing_feasibility_name = manufacturing_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}




	@Id
	@Column(name="manufacturing_feasibility_id")
    @GeneratedValue
	public int getManufacturing_feasibility_id() {
		return manufacturing_feasibility_id;
	}

	public void setManufacturing_feasibility_id(int manufacturing_feasibility_id) {
		this.manufacturing_feasibility_id = manufacturing_feasibility_id;
	}

	public String getManufacturing_feasibility_name() {
		return manufacturing_feasibility_name;
	}

	public void setManufacturing_feasibility_name(String manufacturing_feasibility_name) {
		this.manufacturing_feasibility_name = manufacturing_feasibility_name;
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
