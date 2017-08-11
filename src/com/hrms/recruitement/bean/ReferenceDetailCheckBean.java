package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reference_detail_check_tbl")

public class ReferenceDetailCheckBean {
	
	private InterviewFeedbackBean interviewFeedbackBean;
	
	@Id
	@GeneratedValue
	private int reference_detail_check_id;
	private String reference1_name;
	private String reference2_name;
	private String reference1_designation;
	private String reference2_designation;
	private String reference1_contact_no;
	private String reference2_contact_no;
	private String reference1_email_id;
	private String reference2_email_id;
	private String reference1_organization;
	private String reference2_organization;
	private String reference1_name_of_acquaintance;
	private String reference2_name_of_acquaintance;
	private String reference1_period_of_acquaintance;
	private String reference2_period_of_acquaintance;
	
	
	public ReferenceDetailCheckBean(){}
	
	public ReferenceDetailCheckBean(InterviewFeedbackBean interviewFeedbackBean, String reference1_name,
			String reference2_name, String reference1_designation, String reference2_designation,
			String reference1_contact_no, String reference2_contact_no, String reference1_email_id,
			String reference2_email_id, String reference1_organization, String reference2_organization,
			String reference1_name_of_acquaintance, String reference2_name_of_acquaintance,
			String reference1_period_of_acquaintance, String reference2_period_of_acquaintance) {
		super();
		this.interviewFeedbackBean = interviewFeedbackBean;
		this.reference1_name = reference1_name;
		this.reference2_name = reference2_name;
		this.reference1_designation = reference1_designation;
		this.reference2_designation = reference2_designation;
		this.reference1_contact_no = reference1_contact_no;
		this.reference2_contact_no = reference2_contact_no;
		this.reference1_email_id = reference1_email_id;
		this.reference2_email_id = reference2_email_id;
		this.reference1_organization = reference1_organization;
		this.reference2_organization = reference2_organization;
		this.reference1_name_of_acquaintance = reference1_name_of_acquaintance;
		this.reference2_name_of_acquaintance = reference2_name_of_acquaintance;
		this.reference1_period_of_acquaintance = reference1_period_of_acquaintance;
		this.reference2_period_of_acquaintance = reference2_period_of_acquaintance;
	}
	@Id
	@GeneratedValue
	@Column(name="reference_detail_check_id")
	public int getReference_detail_check_id() {
		return reference_detail_check_id;
	}
	public void setReference_detail_check_id(int reference_detail_check_id) {
		this.reference_detail_check_id = reference_detail_check_id;
	}
	public String getReference1_name() {
		return reference1_name;
	}
	public void setReference1_name(String reference1_name) {
		this.reference1_name = reference1_name;
	}
	public String getReference2_name() {
		return reference2_name;
	}
	public void setReference2_name(String reference2_name) {
		this.reference2_name = reference2_name;
	}
	public String getReference1_designation() {
		return reference1_designation;
	}
	public void setReference1_designation(String reference1_designation) {
		this.reference1_designation = reference1_designation;
	}
	public String getReference2_designation() {
		return reference2_designation;
	}
	public void setReference2_designation(String reference2_designation) {
		this.reference2_designation = reference2_designation;
	}
	public String getReference1_contact_no() {
		return reference1_contact_no;
	}
	public void setReference1_contact_no(String reference1_contact_no) {
		this.reference1_contact_no = reference1_contact_no;
	}
	public String getReference2_contact_no() {
		return reference2_contact_no;
	}
	public void setReference2_contact_no(String reference2_contact_no) {
		this.reference2_contact_no = reference2_contact_no;
	}
	public String getReference1_email_id() {
		return reference1_email_id;
	}
	public void setReference1_email_id(String reference1_email_id) {
		this.reference1_email_id = reference1_email_id;
	}
	public String getReference2_email_id() {
		return reference2_email_id;
	}
	public void setReference2_email_id(String reference2_email_id) {
		this.reference2_email_id = reference2_email_id;
	}
	public String getReference1_organization() {
		return reference1_organization;
	}
	public void setReference1_organization(String reference1_organization) {
		this.reference1_organization = reference1_organization;
	}
	public String getReference2_organization() {
		return reference2_organization;
	}
	public void setReference2_organization(String reference2_organization) {
		this.reference2_organization = reference2_organization;
	}
	public String getReference1_name_of_acquaintance() {
		return reference1_name_of_acquaintance;
	}
	public void setReference1_name_of_acquaintance(String reference1_name_of_acquaintance) {
		this.reference1_name_of_acquaintance = reference1_name_of_acquaintance;
	}
	public String getReference2_name_of_acquaintance() {
		return reference2_name_of_acquaintance;
	}
	public void setReference2_name_of_acquaintance(String reference2_name_of_acquaintance) {
		this.reference2_name_of_acquaintance = reference2_name_of_acquaintance;
	}
	public String getReference1_period_of_acquaintance() {
		return reference1_period_of_acquaintance;
	}
	public void setReference1_period_of_acquaintance(String reference1_period_of_acquaintance) {
		this.reference1_period_of_acquaintance = reference1_period_of_acquaintance;
	}
	public String getReference2_period_of_acquaintance() {
		return reference2_period_of_acquaintance;
	}
	public void setReference2_period_of_acquaintance(String reference2_period_of_acquaintance) {
		this.reference2_period_of_acquaintance = reference2_period_of_acquaintance;
	}

	@ManyToOne
	@JoinColumn(name="interview_feedback_id")
	public InterviewFeedbackBean getInterviewFeedbackBean() {
		return interviewFeedbackBean;
	}
	public void setInterviewFeedbackBean(InterviewFeedbackBean interviewFeedbackBean) {
		this.interviewFeedbackBean = interviewFeedbackBean;
	}
	
		
	

}
