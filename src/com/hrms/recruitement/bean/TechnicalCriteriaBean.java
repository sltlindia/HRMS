package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="technical_criteria_tbl")
public class TechnicalCriteriaBean {

	private int technical_criteria_id;
	private String technical_criteria_name;
	
	
	
	public TechnicalCriteriaBean() {
	}

	
	
	public TechnicalCriteriaBean(String technical_criteria_name) {
		this.technical_criteria_name = technical_criteria_name;
	}



	@Id 
	@Column(name="technical_criteria_id")
	@GeneratedValue
	public int getTechnical_criteria_id() {
		return technical_criteria_id;
	}
	public void setTechnical_criteria_id(int technical_criteria_id) {
		this.technical_criteria_id = technical_criteria_id;
	}
	
	@Column(name="technical_criteria_name")
	public String getTechnical_criteria_name() {
		return technical_criteria_name;
	}
	public void setTechnical_criteria_name(String technical_criteria_name) {
		this.technical_criteria_name = technical_criteria_name;
	}
	
	
}
