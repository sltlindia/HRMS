package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="interview_manager_email_tbl")
public class InterviewManagerEmailBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private int interview_manager_email_id;
	private String email_id;
	
	private ResumeDataBean resumeDataBean;
	
	public InterviewManagerEmailBean() {}
	
	

	public InterviewManagerEmailBean(String email_id, ResumeDataBean resumeDataBean) {
		this.email_id = email_id;
		this.resumeDataBean = resumeDataBean;
	}
	
	@Id
	@GeneratedValue
	@Column(name="interview_manager_email_id")
	public int getInterview_manager_email_id() {
		return interview_manager_email_id;
	}

	public void setInterview_manager_email_id(int interview_manager_email_id) {
		this.interview_manager_email_id = interview_manager_email_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	@ManyToOne
	@JoinColumn(name="resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}

	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}
}
