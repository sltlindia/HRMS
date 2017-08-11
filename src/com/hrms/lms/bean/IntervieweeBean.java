package com.hrms.lms.bean;

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
@Table(name="interviewee_tbl")
public class IntervieweeBean  implements Serializable{

	private int interviewee_id;
	private String interviewee_name;
	private String designation;
	private String interview_date;
	private String interviewee_location;
	private String interviewer_name;
	private String interviewer_feedback;
	private String remark;
	private String interviewee_in_time;
	private String interviewee_out_time;
	private String date_of_birth;
	private String email_id;
	private String mobile_number;
	private String location;
	
	private EmployeeBean employeeBean;
	
	public IntervieweeBean() {
		
	}
	

	public IntervieweeBean(String interviewee_name, String designation, String interview_date,
			String interviewee_location, String interviewer_name, String interviewer_feedback, String remark,
			EmployeeBean employeeBean, String interviewee_in_time, String interviewee_out_time, String date_of_birth, String email_id, String mobile_number, String location) {
	
		this.interviewee_name = interviewee_name;
		this.designation = designation;
		this.interview_date = interview_date;
		this.interviewee_location = interviewee_location;
		this.interviewer_name = interviewer_name;
		this.interviewer_feedback = interviewer_feedback;
		this.remark = remark;
		this.employeeBean = employeeBean;
		this.interviewee_in_time = interviewee_in_time;
		this.interviewee_out_time =interviewee_out_time;
		this.date_of_birth = date_of_birth;
		this.email_id = email_id;
		this.mobile_number = mobile_number;
		this.location = location;
	}

	
	

	public IntervieweeBean(int interviewee_id, String interviewee_name, String designation, String interview_date,
			String interviewee_location, String interviewer_name, String interviewer_feedback, String remark,
			EmployeeBean employeeBean, String interviewee_in_time, String interviewee_out_time, String date_of_birth, String email_id, String mobile_number, String location) {
		
		this.interviewee_id = interviewee_id;
		this.interviewee_name = interviewee_name;
		this.designation = designation;
		this.interview_date = interview_date;
		this.interviewee_location = interviewee_location;
		this.interviewer_name = interviewer_name;
		this.interviewer_feedback = interviewer_feedback;
		this.remark = remark;
		this.employeeBean = employeeBean;
		this.interviewee_in_time = interviewee_in_time;
		this.interviewee_out_time = interviewee_out_time;
		this.date_of_birth = date_of_birth;
		this.email_id = email_id;
		this.mobile_number = mobile_number;
		this.location = location;
	}


	@Id
	@Column(name="interviewee_id")
    @GeneratedValue
	public int getInterviewee_id() {
		return interviewee_id;
	}

	public void setInterviewee_id(int interviewee_id) {
		this.interviewee_id = interviewee_id;
	}

	@Column(name="interviewee_name")
	public String getInterviewee_name() {
		return interviewee_name;
	}

	public void setInterviewee_name(String interviewee_name) {
		this.interviewee_name = interviewee_name;
	}

	@Column(name="designation")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name="interview_date")
	public String getInterview_date() {
		return interview_date;
	}

	public void setInterview_date(String interview_date) {
		this.interview_date = interview_date;
	}

	@Column(name="interviewee_location")
	public String getInterviewee_location() {
		return interviewee_location;
	}

	public void setInterviewee_location(String interviewee_location) {
		this.interviewee_location = interviewee_location;
	}

	
	@Column(name="interviewer_name")
	public String getInterviewer_name() {
		return interviewer_name;
	}


	public void setInterviewer_name(String interviewer_name) {
		this.interviewer_name = interviewer_name;
	}

	@Column(name="interviewer_feedback")
	public String getInterviewer_feedback() {
		return interviewer_feedback;
	}

	public void setInterviewer_feedback(String interviewer_feedback) {
		this.interviewer_feedback = interviewer_feedback;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}


	@Column(name="interviewee_in_time")
	public String getInterviewee_in_time() {
		return interviewee_in_time;
	}


	public void setInterviewee_in_time(String interviewee_in_time) {
		this.interviewee_in_time = interviewee_in_time;
	}


	@Column(name="interviewee_out_time")
	public String getInterviewee_out_time() {
		return interviewee_out_time;
	}


	public void setInterviewee_out_time(String interviewee_out_time) {
		this.interviewee_out_time = interviewee_out_time;
	}


	@Column(name="date_of_birth")
	public String getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	@Column(name="email_id")
	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@Column(name="mobile_number")
	public String getMobile_number() {
		return mobile_number;
	}


	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}


	@Column(name="location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}
