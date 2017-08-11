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
@Table(name="fixture_feasibility_tbl")
public class FixtureFeasibiltyBean implements Serializable {
	
	private int fixture_feasibility_id;
	private String  fixture_feasibility_name;
	private String remarks;
	
	private ProjectMasterBean projectMasterBean;

	
	public FixtureFeasibiltyBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public FixtureFeasibiltyBean(int fixture_feasibility_id, String fixture_feasibility_name, String remarks,
			ProjectMasterBean projectMasterBean) {
		super();
		this.fixture_feasibility_id = fixture_feasibility_id;
		this.fixture_feasibility_name = fixture_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}




	public FixtureFeasibiltyBean(String fixture_feasibility_name, String remarks, ProjectMasterBean projectMasterBean) {
		super();
		this.fixture_feasibility_name = fixture_feasibility_name;
		this.remarks = remarks;
		this.projectMasterBean = projectMasterBean;
	}




	@Id
	@Column(name="fixture_feasibility_id")
    @GeneratedValue
	public int getFixture_feasibility_id() {
		return fixture_feasibility_id;
	}

	public void setFixture_feasibility_id(int fixture_feasibility_id) {
		this.fixture_feasibility_id = fixture_feasibility_id;
	}

	public String getFixture_feasibility_name() {
		return fixture_feasibility_name;
	}

	public void setFixture_feasibility_name(String fixture_feasibility_name) {
		this.fixture_feasibility_name = fixture_feasibility_name;
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
