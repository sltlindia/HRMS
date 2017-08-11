package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="exit_interview_score_tbl")
public class ExitInterviewScoreBean {
	
	
	private int exit_interview_score_id;
	private String exit_interview_attribute;
	private String exit_interview_score;
	private String exit_interview_comments;
	
	
	private ExitInterviewEmployeeBean exitInterviewEmployeeBean;


	public ExitInterviewScoreBean() {
	
	}
	
	
	
	public ExitInterviewScoreBean(String exit_interview_attribute, String exit_interview_score,
			String exit_interview_comments, ExitInterviewEmployeeBean exitInterviewEmployeeBean) {
		super();
		this.exit_interview_attribute = exit_interview_attribute;
		this.exit_interview_score = exit_interview_score;
		this.exit_interview_comments = exit_interview_comments;
		this.exitInterviewEmployeeBean = exitInterviewEmployeeBean;
	}

	@Id 
    @Column(name="exit_interview_score_id")
    @GeneratedValue
	public int getExit_interview_score_id() {
		return exit_interview_score_id;
	}

	public void setExit_interview_score_id(int exit_interview_score_id) {
		this.exit_interview_score_id = exit_interview_score_id;
	}

	@Column(name="exit_interview_attribute")
	public String getExit_interview_attribute() {
		return exit_interview_attribute;
	}

	public void setExit_interview_attribute(String exit_interview_attribute) {
		this.exit_interview_attribute = exit_interview_attribute;
	}

	@Column(name="exit_interview_score")
	public String getExit_interview_score() {
		return exit_interview_score;
	}

	public void setExit_interview_score(String exit_interview_score) {
		this.exit_interview_score = exit_interview_score;
	}

	@Column(name="exit_interview_comments")
	public String getExit_interview_comments() {
		return exit_interview_comments;
	}

	public void setExit_interview_comments(String exit_interview_comments) {
		this.exit_interview_comments = exit_interview_comments;
	}

	@ManyToOne
	@JoinColumn(name="exit_interview_employee_id")
	public ExitInterviewEmployeeBean getExitInterviewEmployeeBean() {
		return exitInterviewEmployeeBean;
	}

	public void setExitInterviewEmployeeBean(ExitInterviewEmployeeBean exitInterviewEmployeeBean) {
		this.exitInterviewEmployeeBean = exitInterviewEmployeeBean;
	}
	
}
