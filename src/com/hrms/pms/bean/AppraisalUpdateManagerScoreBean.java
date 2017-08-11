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
@Table(name="appraisal_update_manager_score_tbl")
public class AppraisalUpdateManagerScoreBean implements Serializable{

	
	private int appraisal_update_manager_score_id;
	private double score;
	private AppraisalBean appraisalBean;
	private AppraisalCriteriaManagerBean appraisalCriteriaManagerBean;
	
	public AppraisalUpdateManagerScoreBean() {
		// TODO Auto-generated constructor stub
	}
	
	public AppraisalUpdateManagerScoreBean(double score,AppraisalBean appraisalBean,AppraisalCriteriaManagerBean appraisalCriteriaManagerBean) {

	this.score = score;
	this.appraisalBean = appraisalBean;
	this.appraisalCriteriaManagerBean = appraisalCriteriaManagerBean;
	
	}

	@Id
	@Column(name="appraisal_update_manager_score_id")
    @GeneratedValue
	public int getAppraisal_update_manager_score_id() {
		return appraisal_update_manager_score_id;
	}

	public void setAppraisal_update_manager_score_id(int appraisal_update_manager_score_id) {
		this.appraisal_update_manager_score_id = appraisal_update_manager_score_id;
	}

	
	
	
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
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
	@JoinColumn(name="appraisal_criteria_manager_id")
	public AppraisalCriteriaManagerBean getAppraisalCriteriaManagerBean() {
		return appraisalCriteriaManagerBean;
	}

	public void setAppraisalCriteriaManagerBean(AppraisalCriteriaManagerBean appraisalCriteriaManagerBean) {
		this.appraisalCriteriaManagerBean = appraisalCriteriaManagerBean;
	}
	
	
	
    
    
	
	
	
	
	
	
	
	
}
