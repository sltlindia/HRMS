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
@Table(name="specific_criteria_month_tbl")
public class SpecificCriteriaMonthBean implements Serializable {

	private int specific_criteria_month_id;
	
	private YearBean yearBean;
	private MonthBean monthBean;
	private SpecificCriteriaBean specificCriteriaBean;
	
	
	public SpecificCriteriaMonthBean() {
		// TODO Auto-generated constructor stub
	}
	
	public SpecificCriteriaMonthBean(SpecificCriteriaBean specificCriteriaBean,MonthBean monthBean,YearBean yearBean) {
	this.specificCriteriaBean = specificCriteriaBean;
	this.monthBean = monthBean;
	this.yearBean = yearBean;
	}
	
	
	@Id 
	@Column(name="specific_criteria_month_id")
	@GeneratedValue
	public int getSpecific_criteria_month_id() {
		return specific_criteria_month_id;
	}
	public void setSpecific_criteria_month_id(int specific_criteria_month_id) {
		this.specific_criteria_month_id = specific_criteria_month_id;
	}
	
	@ManyToOne
	@JoinColumn(name="year_id")
	public YearBean getYearBean() {
		return yearBean;
	}
	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}
	
	@ManyToOne
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}
	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
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
