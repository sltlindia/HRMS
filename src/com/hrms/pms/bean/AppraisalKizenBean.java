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
@Table(name="appraisal_kaizen_tbl")
public class AppraisalKizenBean implements Serializable {
	
	private int appraisal_kaizen_id;
	private int kizen;
	private int kizen_approve;
	private String remarks;
	
	
	private AppraisalBean appraisalBean;
	private AppraisalGradeBean appraisalGradeBean;
	
	
	public AppraisalKizenBean() {
		// TODO Auto-generated constructor stub
	}
	
	public AppraisalKizenBean(int kizen,int kizen_approve,String remarks,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean) {
		this.kizen = kizen;
		this.kizen_approve = kizen_approve;
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
	
	}
	
	public AppraisalKizenBean(int kizen,int kizen_approve,String remarks,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean,int appraisal_kaizen_id) {
		this.kizen = kizen;
		this.kizen_approve = kizen_approve;
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
		this.appraisal_kaizen_id = appraisal_kaizen_id;
	
	}
	
	@Id
	@Column(name="appraisal_kaizen_id")
    @GeneratedValue
	public int getAppraisal_kaizen_id() {
		return appraisal_kaizen_id;
	}
	public void setAppraisal_kaizen_id(int appraisal_kaizen_id) {
		this.appraisal_kaizen_id = appraisal_kaizen_id;
	}
	public int getKizen() {
		return kizen;
	}
	public void setKizen(int kizen) {
		this.kizen = kizen;
	}
	public int getKizen_approve() {
		return kizen_approve;
	}
	public void setKizen_approve(int kizen_approve) {
		this.kizen_approve = kizen_approve;
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
	
	

}
