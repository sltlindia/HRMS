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
@Table(name="appraisal_training_tbl")
public class AppraisalTrainingBean implements Serializable {

	
	private int appraisal_training_id;
	private String topic;
	private String faculty;
	private String date;
	private int hrs;
	private String remarks;
	
	private AppraisalBean appraisalBean;
	
	public AppraisalTrainingBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AppraisalTrainingBean(String topic,String faculty,String date,int hrs,String remarks,AppraisalBean appraisalBean) {

		this.topic = topic;
		this.faculty = faculty;
		this.date = date;
		this.hrs = hrs;
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
	}
	
	public AppraisalTrainingBean(String topic,String faculty,String date,int hrs,String remarks,AppraisalBean appraisalBean,int appraisal_training_id) {

		this.topic = topic;
		this.faculty = faculty;
		this.date = date;
		this.hrs = hrs;
		this.remarks = remarks;
		this.appraisalBean = appraisalBean;
		this.appraisal_training_id = appraisal_training_id;
	}

	@Id
	@Column(name="appraisal_training_id")
    @GeneratedValue
	public int getAppraisal_training_id() {
		return appraisal_training_id;
	}

	public void setAppraisal_training_id(int appraisal_training_id) {
		this.appraisal_training_id = appraisal_training_id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
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
	
	
	
	
	
	
}
