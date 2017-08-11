package com.hrms.pms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="specific_criteria_softskill_tbl")
public class SpecificCriteriaSoftskillBean {

	private int specific_criteria_softskill_id;
	
	private SoftskillBean softskillBean;
	private SpecificCriteriaBean specificCriteriaBean;
	
	
	public SpecificCriteriaSoftskillBean() {
		// TODO Auto-generated constructor stub
	}
	
	public SpecificCriteriaSoftskillBean(SpecificCriteriaBean specificCriteriaBean,SoftskillBean softskillBean) {
		this.specificCriteriaBean = specificCriteriaBean;
		this.softskillBean = softskillBean;
	
	}
	
	@Id 
	@Column(name="specific_criteria_softskill_id")
	@GeneratedValue
	public int getSpecific_criteria_softskill_id() {
		return specific_criteria_softskill_id;
	}
	public void setSpecific_criteria_softskill_id(int specific_criteria_softskill_id) {
		this.specific_criteria_softskill_id = specific_criteria_softskill_id;
	}
	
	@ManyToOne
	@JoinColumn(name="softskill_id")
	public SoftskillBean getSoftskillBean() {
		return softskillBean;
	}
	public void setSoftskillBean(SoftskillBean softskillBean) {
		this.softskillBean = softskillBean;
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
