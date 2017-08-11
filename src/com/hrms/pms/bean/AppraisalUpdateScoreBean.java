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
@Table(name="appraisal_update_score_tbl")
public class AppraisalUpdateScoreBean implements Serializable{

	
	private int appraisal_update_score_id;
	private double score;
	
	
	private AppraisalBean appraisalBean;
	private AppraisalCriteriaBean appraisalCriteriaBean;
	
	public AppraisalUpdateScoreBean(double score,AppraisalBean appraisalBean,AppraisalCriteriaBean appraisalCriteriaBean) {

		this.score = score;
		this.appraisalBean = appraisalBean;
		this.appraisalCriteriaBean = appraisalCriteriaBean;
	
	}
	
	
	public AppraisalUpdateScoreBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name="appraisal_update_score_id")
    @GeneratedValue
	public int getAppraisal_update_score_id() {
		return appraisal_update_score_id;
	}
	public void setAppraisal_update_score_id(int appraisal_update_score_id) {
		this.appraisal_update_score_id = appraisal_update_score_id;
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
	@JoinColumn(name="appraisal_criteria_id")
	public AppraisalCriteriaBean getAppraisalCriteriaBean() {
		return appraisalCriteriaBean;
	}
	public void setAppraisalCriteriaBean(AppraisalCriteriaBean appraisalCriteriaBean) {
		this.appraisalCriteriaBean = appraisalCriteriaBean;
	}


	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}
	
	
	
	
}
