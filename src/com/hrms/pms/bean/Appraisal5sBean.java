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
@Table(name="appraisal_5s_tbl")
public class Appraisal5sBean implements Serializable {

	
	private int appraisal_5s_id;
	private int score;
	private String remarks;
	
	
	private AppraisalBean appraisalBean;
	private AppraisalGradeBean appraisalGradeBean;
	private QuterlyMonthBean quterlyMonthBean;
	
	public Appraisal5sBean() {
		// TODO Auto-generated constructor stub
	}
	
	public Appraisal5sBean(int score,String remarks,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean,QuterlyMonthBean quterlyMonthBean) {

		this.score = score;
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
		this.quterlyMonthBean = quterlyMonthBean;
	}
	
	public Appraisal5sBean(int score,String remarks,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean,QuterlyMonthBean quterlyMonthBean,int appraisal_5s_id) {

		this.score = score;
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
		this.quterlyMonthBean = quterlyMonthBean;
		this.appraisal_5s_id = appraisal_5s_id;
	}
	
	@Id
	@Column(name="appraisal_5s_id")
    @GeneratedValue
	public int getAppraisal_5s_id() {
		return appraisal_5s_id;
	}
	public void setAppraisal_5s_id(int appraisal_5s_id) {
		this.appraisal_5s_id = appraisal_5s_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
	@JoinColumn(name="quarterly_month_id")
	public QuterlyMonthBean getQuterlyMonthBean() {
		return quterlyMonthBean;
	}
	public void setQuterlyMonthBean(QuterlyMonthBean quterlyMonthBean) {
		this.quterlyMonthBean = quterlyMonthBean;
	}
	
	
	
	
}
