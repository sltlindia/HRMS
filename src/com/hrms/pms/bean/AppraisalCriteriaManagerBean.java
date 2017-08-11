package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appraisal_criteria_manager_tbl")
public class AppraisalCriteriaManagerBean implements Serializable {

	private int appraisal_criteria_manager_id;
	private String appraisal_criteria_name;
	private double weightage;
	
	
	@Id
	@Column(name="appraisal_criteria_manager_id")
    @GeneratedValue
	public int getAppraisal_criteria_manager_id() {
		return appraisal_criteria_manager_id;
	}
	public void setAppraisal_criteria_manager_id(int appraisal_criteria_manager_id) {
		this.appraisal_criteria_manager_id = appraisal_criteria_manager_id;
	}
	public String getAppraisal_criteria_name() {
		return appraisal_criteria_name;
	}
	public void setAppraisal_criteria_name(String appraisal_criteria_name) {
		this.appraisal_criteria_name = appraisal_criteria_name;
	}
	public double getWeightage() {
		return weightage;
	}
	public void setWeightage(double weightage) {
		this.weightage = weightage;
	}
	
	
	
	
}
