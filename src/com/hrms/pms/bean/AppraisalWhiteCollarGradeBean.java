package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="appraisal_white_grade_tbl")
public class AppraisalWhiteCollarGradeBean implements Serializable {

	private int appraisal_white_grade_id;
	private String goals;
	private String result;
	private String employee_comment;
	private String weightage;
	private String appraiser_comment;
	
	private AppraisalGradeBean appraisalGradeBean;
	private AppraisalBean appraisalBean;
	
	public AppraisalWhiteCollarGradeBean() {
		// TODO Auto-generated constructor stub
	}
	
public AppraisalWhiteCollarGradeBean(String goals,String result,String employee_comment,AppraisalBean appraisalBean,String weightage,String appraiser_comment) {

	this.goals = goals;
	this.result = result;
	this.employee_comment = employee_comment;
	this.weightage = weightage;
	this.appraisalBean = appraisalBean;
	this.employee_comment = employee_comment;
	this.appraiser_comment = appraiser_comment;
}




	
	public AppraisalWhiteCollarGradeBean(int appraisal_white_grade_id, String goals, String result, String employee_comment,
		 String appraiser_comment,
		AppraisalBean appraisalBean,String weightage) {
	super();
	this.appraisal_white_grade_id = appraisal_white_grade_id;
	this.goals = goals;
	this.result = result;
	this.employee_comment = employee_comment;
	this.appraiser_comment = appraiser_comment;
	this.appraisalBean = appraisalBean;
	this.weightage = weightage;
	
}

	@Id
	@Column(name="appraisal_white_grade_id")
    @GeneratedValue
	public int getAppraisal_white_grade_id() {
		return appraisal_white_grade_id;
	}
	public void setAppraisal_white_grade_id(int appraisal_white_grade_id) {
		this.appraisal_white_grade_id = appraisal_white_grade_id;
	}
	
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getEmployee_comment() {
		return employee_comment;
	}
	public void setEmployee_comment(String employee_comment) {
		this.employee_comment = employee_comment;
	}
	
	public String getWeightage() {
		return weightage;
	}
	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}
	
	public String getAppraiser_comment() {
		return appraiser_comment;
	}
	public void setAppraiser_comment(String appraiser_comment) {
		this.appraiser_comment = appraiser_comment;
	}
	
	@ManyToOne
	@JoinColumn(name="appraisal_grade_id")
	public AppraisalGradeBean getAppraisalGradeBean() {
		return appraisalGradeBean;
	}
	public void setAppraisalGradeBean(AppraisalGradeBean appraisalGradeBean) {
		this.appraisalGradeBean = appraisalGradeBean;
	}
	
	@ManyToOne
	@JoinColumn(name="appraisal_id")
	public AppraisalBean getAppraisalBean() {
		return appraisalBean;
	}
	public void setAppraisalBean(AppraisalBean appraisalBean) {
		this.appraisalBean = appraisalBean;
	}
	
	
	
	
	
}
