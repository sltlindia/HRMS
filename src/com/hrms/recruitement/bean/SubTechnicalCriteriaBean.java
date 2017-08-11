package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sub_technical_criteria_tbl")
public class SubTechnicalCriteriaBean {

	private int sub_technical_criteria_id;
	private String sub_technical_criteria_name;
	private String description;
	
	private TechnicalCriteriaBean technicalCriteriaBean;
	
	

	public SubTechnicalCriteriaBean() {
	}

	public SubTechnicalCriteriaBean( String sub_technical_criteria_name,
			String description, TechnicalCriteriaBean technicalCriteriaBean) {
		this.sub_technical_criteria_name = sub_technical_criteria_name;
		this.description = description;
		this.technicalCriteriaBean = technicalCriteriaBean;
	}
	
	@Id 
	@Column(name="sub_technical_criteria_id")
	@GeneratedValue
	public int getSub_technical_criteria_id() {
		return sub_technical_criteria_id;
	}

	public void setSub_technical_criteria_id(int sub_technical_criteria_id) {
		this.sub_technical_criteria_id = sub_technical_criteria_id;
	}

	public String getSub_technical_criteria_name() {
		return sub_technical_criteria_name;
	}

	public void setSub_technical_criteria_name(String sub_technical_criteria_name) {
		this.sub_technical_criteria_name = sub_technical_criteria_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@ManyToOne
	@JoinColumn(name="technical_criteria_id")
	public TechnicalCriteriaBean getTechnicalCriteriaBean() {
		return technicalCriteriaBean;
	}

	public void setTechnicalCriteriaBean(TechnicalCriteriaBean technicalCriteriaBean) {
		this.technicalCriteriaBean = technicalCriteriaBean;
	}
	
	
	
}
