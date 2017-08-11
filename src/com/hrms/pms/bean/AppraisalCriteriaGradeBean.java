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
@Table(name="appraisal_criteria_grade_tbl")
public class AppraisalCriteriaGradeBean implements Serializable{

	private int appraisal_criteria_grade_id;
	private String remarks;
	
	private AppraisalBean appraisalBean;
	private AppraisalGradeBean appraisalGradeBean;
	private AppraisalCriteriaBean appraisalCriteriaBean;
	
	public AppraisalCriteriaGradeBean() {
		// TODO Auto-generated constructor stub
	}
	
	public AppraisalCriteriaGradeBean(String remarks,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean,AppraisalCriteriaBean appraisalCriteriaBean) {
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
		this.appraisalCriteriaBean = appraisalCriteriaBean;
	}
	
	public AppraisalCriteriaGradeBean(String remarks,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean,AppraisalCriteriaBean appraisalCriteriaBean,int appraisal_criteria_grade_id) {
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
		this.appraisalCriteriaBean = appraisalCriteriaBean;
		this.appraisal_criteria_grade_id = appraisal_criteria_grade_id;
	}
	
	@Id
	@Column(name="appraisal_criteria_grade_id")
    @GeneratedValue
	public int getAppraisal_criteria_grade_id() {
		return appraisal_criteria_grade_id;
	}
	public void setAppraisal_criteria_grade_id(int appraisal_criteria_grade_id) {
		this.appraisal_criteria_grade_id = appraisal_criteria_grade_id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	@ManyToOne
	@JoinColumn(name="appraisal_id")
	public AppraisalBean getAppraisalBean() {
		return appraisalBean;
	}
	public void setAppraisalBean(AppraisalBean appraisalBean) {
		this.appraisalBean = appraisalBean;
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
	@JoinColumn(name="appraisal_criteria_id")
	public AppraisalCriteriaBean getAppraisalCriteriaBean() {
		return appraisalCriteriaBean;
	}
	public void setAppraisalCriteriaBean(AppraisalCriteriaBean appraisalCriteriaBean) {
		this.appraisalCriteriaBean = appraisalCriteriaBean;
	}
	
	
	
	
	
}
