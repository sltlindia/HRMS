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
@Table(name="quality_feasibility_tbl")
public class QualityFeasibilityBean implements Serializable{
	
	private int quality_feasibility_id;
	private String  quality_feasibility_name;
	private String remarks;
	
	private ProjectMasterBean projectMasterBean;
	
	public QualityFeasibilityBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public QualityFeasibilityBean(int quality_feasibility_id, String quality_feasibility_name, String remarks,
			ProjectMasterBean projectMasterBean) {
		super();
		this.quality_feasibility_id = quality_feasibility_id;
		this.quality_feasibility_name = quality_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}



	public QualityFeasibilityBean(String quality_feasibility_name, String remarks,
			ProjectMasterBean projectMasterBean) {
		super();
		this.quality_feasibility_name = quality_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}



	@Id
	@Column(name="quality_feasibility_id")
    @GeneratedValue
	public int getQuality_feasibility_id() {
		return quality_feasibility_id;
	}

	public void setQuality_feasibility_id(int quality_feasibility_id) {
		this.quality_feasibility_id = quality_feasibility_id;
	}

	public String getQuality_feasibility_name() {
		return quality_feasibility_name;
	}

	public void setQuality_feasibility_name(String quality_feasibility_name) {
		this.quality_feasibility_name = quality_feasibility_name;
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
