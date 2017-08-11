package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="project_hold_history_tbl")
public class ProjectHoldHistoryBean implements Serializable {


	private int project_hold_history_id;
	private String project_hold_date;
	private String project_resume_date;
	private String reason;
	
	private ProjectMasterBean projectMasterBean;

	
	public ProjectHoldHistoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ProjectHoldHistoryBean(String project_hold_date, String project_resume_date, String reason,
			ProjectMasterBean projectMasterBean) {
		super();
		this.project_hold_date = project_hold_date;
		this.project_resume_date = project_resume_date;
		this.reason = reason;
		this.projectMasterBean = projectMasterBean;
	}




	@Id
	@Column(name="project_hold_history_id")
    @GeneratedValue
	public int getProject_hold_history_id() {
		return project_hold_history_id;
	}

	public void setProject_hold_history_id(int project_hold_history_id) {
		this.project_hold_history_id = project_hold_history_id;
	}

	
	
	public String getProject_hold_date() {
		return project_hold_date;
	}

	public void setProject_hold_date(String project_hold_date) {
		this.project_hold_date = project_hold_date;
	}

	public String getProject_resume_date() {
		return project_resume_date;
	}

	public void setProject_resume_date(String project_resume_date) {
		this.project_resume_date = project_resume_date;
	}

	
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}

	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}
	
	
	
	
	
	
}
