package com.hrms.recruitement.bean;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="interviewer_panel_tbl")

public class InterviewerPanelBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int interviewer_panel_id;
	private String interviewer_name;
	private String interviewer_expertise;
	private String interviewer_speciality;
	
	private EmployeeBean employeeBean;
	
	
	
	public InterviewerPanelBean() {
	}
	public InterviewerPanelBean(String interviewer_name, String interviewer_expertise,
			String interviewer_speciality, EmployeeBean employeeBean) {
		this.interviewer_name = interviewer_name;
		this.interviewer_expertise = interviewer_expertise;
		this.interviewer_speciality = interviewer_speciality;
		this.employeeBean = employeeBean;
	}
	@Id
	@Column(name="interviewer_panel_id")
	@GeneratedValue
	public int getInterviewer_panel_id() {
		return interviewer_panel_id;
	}
	public void setInterviewer_panel_id(int interviewer_panel_id) {
		this.interviewer_panel_id = interviewer_panel_id;
	}
	
	@Column(name="interviewer_name")
	public String getInterviewer_name() {
		return interviewer_name;
	}
	public void setInterviewer_name(String interviewer_name) {
		this.interviewer_name = interviewer_name;
	}
	
	@Column(name="interviewer_expertise")
	public String getInterviewer_expertise() {
		return interviewer_expertise;
	}
	
	public void setInterviewer_expertise(String interviewer_expertise) {
		this.interviewer_expertise = interviewer_expertise;
	}
	
	@Column(name="interviewer_speciality")
	public String getInterviewer_speciality() {
		return interviewer_speciality;
	}
	public void setInterviewer_speciality(String interviewer_speciality) {
		this.interviewer_speciality = interviewer_speciality;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
	
}
