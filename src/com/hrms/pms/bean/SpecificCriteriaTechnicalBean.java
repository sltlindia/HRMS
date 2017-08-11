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
@Table(name="specific_criteria_technical_tbl")
public class SpecificCriteriaTechnicalBean implements Serializable {

	private int specific_criteria_technical_id;
	
	private TechnicalBean technicalBean;
	private SpecificCriteriaBean specificCriteriaBean;
	
	
	
	public SpecificCriteriaTechnicalBean() {
		// TODO Auto-generated constructor stub
	}
	
	public SpecificCriteriaTechnicalBean(SpecificCriteriaBean specificCriteriaBean,TechnicalBean technicalBean) {
	
		this.specificCriteriaBean = specificCriteriaBean;
		this.technicalBean = technicalBean;
	
	}
	
	
	@Id 
	@Column(name="specific_criteria_technical_id")
	@GeneratedValue
	public int getSpecific_criteria_technical_id() {
		return specific_criteria_technical_id;
	}
	public void setSpecific_criteria_technical_id(int specific_criteria_technical_id) {
		this.specific_criteria_technical_id = specific_criteria_technical_id;
	}
	

	@ManyToOne
	@JoinColumn(name="criteria_id")
	public TechnicalBean getTechnicalBean() {
		return technicalBean;
	}
	public void setTechnicalBean(TechnicalBean technicalBean) {
		this.technicalBean = technicalBean;
	}
	
	@ManyToOne
	@JoinColumn(name="specific_criteria_allocation_id")
	public SpecificCriteriaBean getSpecificCriteriaBean() {
		return specificCriteriaBean;
	}
	public void setSpecificCriteriaBean(SpecificCriteriaBean specificCriteriaBean) {
		this.specificCriteriaBean = specificCriteriaBean;
	}
	
	
	
	
	
}
