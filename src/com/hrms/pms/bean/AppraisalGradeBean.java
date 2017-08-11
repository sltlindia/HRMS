package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appraisal_grade_tbl")
public class AppraisalGradeBean implements Serializable{

	
	private int appraisal_grade_id;
	private String appraisal_grade_name;
	private String title_of_description;
	private String description;
	
	
	public AppraisalGradeBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="appraisal_grade_id")
    @GeneratedValue
	public int getAppraisal_grade_id() {
		return appraisal_grade_id;
	}
	public void setAppraisal_grade_id(int appraisal_grade_id) {
		this.appraisal_grade_id = appraisal_grade_id;
	}
	
	@Column(name="appraisal_grade_name")
	public String getAppraisal_grade_name() {
		return appraisal_grade_name;
	}
	public void setAppraisal_grade_name(String appraisal_grade_name) {
		this.appraisal_grade_name = appraisal_grade_name;
	}
	
	@Column(name="title_of_description")
	public String getTitle_of_description() {
		return title_of_description;
	}
	public void setTitle_of_description(String title_of_description) {
		this.title_of_description = title_of_description;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
