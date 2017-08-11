package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="appraisal_criteria_tbl")
public class AppraisalCriteriaBean implements Serializable {

	private int appraisal_criteria_id;
	private String appraisal_criteria_name;
	private double weightage;
	
	public AppraisalCriteriaBean() {

	}

	
	@Id
	@Column(name="appraisal_criteria_id")
    @GeneratedValue
	public int getAppraisal_criteria_id() {
		return appraisal_criteria_id;
	}

	public void setAppraisal_criteria_id(int appraisal_criteria_id) {
		this.appraisal_criteria_id = appraisal_criteria_id;
	}

	@Column(name="appraisal_criteria_name")
	public String getAppraisal_criteria_name() {
		return appraisal_criteria_name;
	}

	public void setAppraisal_criteria_name(String appraisal_criteria_name) {
		this.appraisal_criteria_name = appraisal_criteria_name;
	}

	@Column(name="weightage")
	public double getWeightage() {
		return weightage;
	}

	public void setWeightage(double weightage) {
		this.weightage = weightage;
	}
	
	
	
}
