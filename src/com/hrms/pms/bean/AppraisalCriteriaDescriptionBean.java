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
@Table(name="appraisal_criteria_description_tbl")
public class AppraisalCriteriaDescriptionBean implements Serializable {

	private int appraisal_criteria_description_id;
	private String appraisal_criteria_description;
	
	private AppraisalCriteriaBean appraisalCriteriaBean;
	private AppraisalGradeBean appraisalGradeBean;
	
	
	public AppraisalCriteriaDescriptionBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name="appraisal_criteria_description_id")
    @GeneratedValue
	public int getAppraisal_criteria_description_id() {
		return appraisal_criteria_description_id;
	}
	public void setAppraisal_criteria_description_id(int appraisal_criteria_description_id) {
		this.appraisal_criteria_description_id = appraisal_criteria_description_id;
	}
	public String getAppraisal_criteria_description() {
		return appraisal_criteria_description;
	}
	public void setAppraisal_criteria_description(String appraisal_criteria_description) {
		this.appraisal_criteria_description = appraisal_criteria_description;
	}
	
	@ManyToOne
	@JoinColumn(name="appraisal_criteria_id")
	public AppraisalCriteriaBean getAppraisalCriteriaBean() {
		return appraisalCriteriaBean;
	}
	public void setAppraisalCriteriaBean(AppraisalCriteriaBean appraisalCriteriaBean) {
		this.appraisalCriteriaBean = appraisalCriteriaBean;
	}
	
	@ManyToOne
	@JoinColumn(name="appraisal_grade_id")
	public AppraisalGradeBean getAppraisalGradeBean() {
		return appraisalGradeBean;
	}
	public void setAppraisalGradeBean(AppraisalGradeBean appraisalGradeBean) {
		this.appraisalGradeBean = appraisalGradeBean;
	}
	
	
	
}
