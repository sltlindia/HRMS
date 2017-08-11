package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="exit_interview_form_attribute_tbl")
public class ExitInterviewFormAttributeBean {

	private int exit_interview_form_attribute_id;
	private String exit_interview_form_attribute;
	
	public ExitInterviewFormAttributeBean() {

	}
	
	public ExitInterviewFormAttributeBean(String exit_interview_form_attribute) {
		this.exit_interview_form_attribute = exit_interview_form_attribute;
	}

	
	@Id 
    @Column(name="exit_interview_form_attribute_id")
    @GeneratedValue
	public int getExit_interview_form_attribute_id() {
		return exit_interview_form_attribute_id;
	}

	public void setExit_interview_form_attribute_id(int exit_interview_form_attribute_id) {
		this.exit_interview_form_attribute_id = exit_interview_form_attribute_id;
	}

	@Column(name="exit_interview_form_attribute")
	public String getExit_interview_form_attribute() {
		return exit_interview_form_attribute;
	}

	public void setExit_interview_form_attribute(String exit_interview_form_attribute) {
		this.exit_interview_form_attribute = exit_interview_form_attribute;
	}

	
	
}
