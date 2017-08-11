package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="exit_interview_manager_comments_tbl")
public class ExitInterviewManagerCommentsBean {

	private int exit_interview_manager_comments_id;
	private String main_issue;
	private String secondary_issue;
	private String key_suggestions;
	
	private EmployeeBean employeeBean;
	private ExitInterviewEmployeeBean exitInterviewEmployeeBean;
	
	
	public ExitInterviewManagerCommentsBean() {

	}
	
	public ExitInterviewManagerCommentsBean(String main_issue, String secondary_issue, String key_suggestions,
			EmployeeBean employeeBean, ExitInterviewEmployeeBean exitInterviewEmployeeBean) {
		super();
		this.main_issue = main_issue;
		this.secondary_issue = secondary_issue;
		this.key_suggestions = key_suggestions;
		this.employeeBean = employeeBean;
		this.exitInterviewEmployeeBean = exitInterviewEmployeeBean;
	}




	@Id 
    @Column(name="exit_interview_manager_comments_id")
    @GeneratedValue
	public int getExit_interview_manager_comments_id() {
		return exit_interview_manager_comments_id;
	}
	public void setExit_interview_manager_comments_id(int exit_interview_manager_comments_id) {
		this.exit_interview_manager_comments_id = exit_interview_manager_comments_id;
	}
	
	@Column(name="main_issue")
	public String getMain_issue() {
		return main_issue;
	}
	public void setMain_issue(String main_issue) {
		this.main_issue = main_issue;
	}
	
	
	@Column(name="secondary_issue")
	public String getSecondary_issue() {
		return secondary_issue;
	}
	public void setSecondary_issue(String secondary_issue) {
		this.secondary_issue = secondary_issue;
	}
	
	
	@Column(name="key_suggestions")
	public String getKey_suggestions() {
		return key_suggestions;
	}
	public void setKey_suggestions(String key_suggestions) {
		this.key_suggestions = key_suggestions;
	}
	
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
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
