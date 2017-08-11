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
@Table(name="work_grade_tbl")
public class WorkGradeBean implements Serializable {

	private int work_grade_id;
	
	private AppraisalBean appraisalBean;
	private WorkBehaviourBean workBehaviourBean;
	private AppraisalGradeBean appraisalGradeBean;
	
	
	public WorkGradeBean() {
		// TODO Auto-generated constructor stub
	}
	
	public WorkGradeBean(AppraisalBean appraisalBean,WorkBehaviourBean workBehaviourBean,AppraisalGradeBean appraisalGradeBean) {

	this.appraisalBean = appraisalBean;
	this.workBehaviourBean = workBehaviourBean;
	this.appraisalGradeBean = appraisalGradeBean;
	}
	
	
	
	public WorkGradeBean(int work_grade_id, AppraisalBean appraisalBean, WorkBehaviourBean workBehaviourBean,
			AppraisalGradeBean appraisalGradeBean) {
		super();
		this.work_grade_id = work_grade_id;
		this.appraisalBean = appraisalBean;
		this.workBehaviourBean = workBehaviourBean;
		this.appraisalGradeBean = appraisalGradeBean;
	}

	@Id
	@Column(name="work_grade_id")
    @GeneratedValue
	public int getWork_grade_id() {
		return work_grade_id;
	}
	public void setWork_grade_id(int work_grade_id) {
		this.work_grade_id = work_grade_id;
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
	@JoinColumn(name="work_behaviors_id")
	public WorkBehaviourBean getWorkBehaviourBean() {
		return workBehaviourBean;
	}
	public void setWorkBehaviourBean(WorkBehaviourBean workBehaviourBean) {
		this.workBehaviourBean = workBehaviourBean;
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
