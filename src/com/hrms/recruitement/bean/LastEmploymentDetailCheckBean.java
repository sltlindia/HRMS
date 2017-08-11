package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "last_employment_detail_check_tbl")

public class LastEmploymentDetailCheckBean {
	
	public LastEmploymentDetailCheckBean(){}
	private InterviewFeedbackBean interviewFeedbackBean;
	
	@Id
	@GeneratedValue
	private int last_employment_detail_check_id;
	private String last_employment;
	private String company_address;
	private String from_date;
	private String to_date;
	private String designation;
	private String employee_code;
	private String contact_no;
	private String mode_of_separation;
	private String annual_salary;
	private String authority_name;
	private String authority_contact_no;
	private String authority_designation;
	private String authority_email_id;
	private String hr_name;
	private String hr_designation;
	private String hr_contact_no;
	private String hr_email_id;
	private String company_functioning;
	private String social_security_no;
	
	
	
	
	
	@Id
	@Column(name="last_employment_detail_check_id")
	@GeneratedValue
	public int getLast_employment_detail_check_id() {
		return last_employment_detail_check_id;
	}
	public void setLast_employment_detail_check_id(int last_employment_detail_check_id) {
		this.last_employment_detail_check_id = last_employment_detail_check_id;
	}
	public String getLast_employment() {
		return last_employment;
	}
	public void setLast_employment(String last_employment) {
		this.last_employment = last_employment;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getMode_of_separation() {
		return mode_of_separation;
	}
	public void setMode_of_separation(String mode_of_separation) {
		this.mode_of_separation = mode_of_separation;
	}
	public String getAnnual_salary() {
		return annual_salary;
	}
	public void setAnnual_salary(String annual_salary) {
		this.annual_salary = annual_salary;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public String getAuthority_contact_no() {
		return authority_contact_no;
	}
	public void setAuthority_contact_no(String authority_contact_no) {
		this.authority_contact_no = authority_contact_no;
	}
	public String getAuthority_designation() {
		return authority_designation;
	}
	public void setAuthority_designation(String authority_designation) {
		this.authority_designation = authority_designation;
	}
	public String getAuthority_email_id() {
		return authority_email_id;
	}
	public void setAuthority_email_id(String authority_email_id) {
		this.authority_email_id = authority_email_id;
	}
	public String getHr_name() {
		return hr_name;
	}
	public void setHr_name(String hr_name) {
		this.hr_name = hr_name;
	}
	public String getHr_designation() {
		return hr_designation;
	}
	public void setHr_designation(String hr_designation) {
		this.hr_designation = hr_designation;
	}
	public String getHr_contact_no() {
		return hr_contact_no;
	}
	public void setHr_contact_no(String hr_contact_no) {
		this.hr_contact_no = hr_contact_no;
	}
	public String getHr_email_id() {
		return hr_email_id;
	}
	public void setHr_email_id(String hr_email_id) {
		this.hr_email_id = hr_email_id;
	}
	public String getCompany_functioning() {
		return company_functioning;
	}
	public void setCompany_functioning(String company_functioning) {
		this.company_functioning = company_functioning;
	}
	public String getSocial_security_no() {
		return social_security_no;
	}
	public void setSocial_security_no(String social_security_no) {
		this.social_security_no = social_security_no;
	}
	
	@ManyToOne
	@JoinColumn(name="interview_feedback_id")
	public InterviewFeedbackBean getInterviewFeedbackBean() {
		return interviewFeedbackBean;
	}
	public void setInterviewFeedbackBean(InterviewFeedbackBean interviewFeedbackBean) {
		this.interviewFeedbackBean = interviewFeedbackBean;
	}
	
	public LastEmploymentDetailCheckBean(InterviewFeedbackBean interviewFeedbackBean, String last_employment,
			String company_address, String from_date, String to_date, String designation, String employee_code,
			String contact_no, String mode_of_separation, String annual_salary, String authority_name,
			String authority_contact_no, String authority_designation, String authority_email_id, String hr_name,
			String hr_designation, String hr_contact_no, String hr_email_id, String company_functioning,
			String social_security_no) {
		super();
		this.interviewFeedbackBean = interviewFeedbackBean;
		this.last_employment = last_employment;
		this.company_address = company_address;
		this.from_date = from_date;
		this.to_date = to_date;
		this.designation = designation;
		this.employee_code = employee_code;
		this.contact_no = contact_no;
		this.mode_of_separation = mode_of_separation;
		this.annual_salary = annual_salary;
		this.authority_name = authority_name;
		this.authority_contact_no = authority_contact_no;
		this.authority_designation = authority_designation;
		this.authority_email_id = authority_email_id;
		this.hr_name = hr_name;
		this.hr_designation = hr_designation;
		this.hr_contact_no = hr_contact_no;
		this.hr_email_id = hr_email_id;
		this.company_functioning = company_functioning;
		this.social_security_no = social_security_no;
	}
	
	
	

}
