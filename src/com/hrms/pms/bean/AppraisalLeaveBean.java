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
@Table(name="appraisal_leave_tbl")
public class AppraisalLeaveBean implements Serializable {

	
	private int appraisal_leave_id;
	private double leave_count;
	private int late_coming;
	
	private AppraisalBean appraisalBean;
	private AppraisalGradeBean appraisalGradeBean;
	

	public AppraisalLeaveBean() {
		// TODO Auto-generated constructor stub
	}
	
	
/*	public AppraisalLeaveBean(double leave_count,int late_coming,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean) {
		this.leave_count = leave_count;
		this.late_coming = late_coming;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
	}*/
	
	public AppraisalLeaveBean(double leave_count,int late_coming,AppraisalBean appraisalBean,AppraisalGradeBean appraisalGradeBean) {
		this.leave_count = leave_count;
		this.late_coming = late_coming;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
	}
	
	
	/*public AppraisalLeaveBean(double leave_count, int late_coming, AppraisalBean appraisalBean,
		AppraisalGradeBean appraisalGradeBean) {
	super();
	this.leave_count = leave_count;
	this.late_coming = late_coming;
	this.appraisalBean = appraisalBean;
	this.appraisalGradeBean = appraisalGradeBean;
}*/


	public AppraisalLeaveBean(double leave_count, int late_coming, AppraisalBean appraisalBean,
			AppraisalGradeBean appraisalGradeBean,int appraisal_leave_id) {
		this.appraisal_leave_id = appraisal_leave_id;
		this.leave_count = leave_count;
		this.late_coming = late_coming;
		this.appraisalBean = appraisalBean;
		this.appraisalGradeBean = appraisalGradeBean;
	}


	@Id
	@Column(name="appraisal_leave_id")
    @GeneratedValue
	public int getAppraisal_leave_id() {
		return appraisal_leave_id;
	}
	public void setAppraisal_leave_id(int appraisal_leave_id) {
		this.appraisal_leave_id = appraisal_leave_id;
	}
	
	@Column(name="leave_count")
	public double getLeave_count() {
		return leave_count;
	}


	public void setLeave_count(double leave_count) {
		this.leave_count = leave_count;
	}


	public int getLate_coming() {
		return late_coming;
	}
	public void setLate_coming(int late_coming) {
		this.late_coming = late_coming;
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
