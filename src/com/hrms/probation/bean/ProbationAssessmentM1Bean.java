package com.hrms.probation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;

@Entity
@Table(name="probation_assessment_direct_tbl")
public class ProbationAssessmentM1Bean {

	
	//Probation Assessment Bean for Adding,Updating,Deleting Scores of employees into table probation_assessment_direct_tbl
	//getter and setter for inserting of all column into probation_assessment_direct_tbl
private int probation_assessment_m1_id;
private Double attribute_score;

private MonthBean monthBean;
private EmployeeBean employeeBean;
private AttributeBean attributeBean;
private YearBean yearBean;
public ProbationAssessmentM1Bean() {
	super();
}


//Constructor Probation Assessment Bean for insertion of data into table probation_assessment_direct_tbl
	//for Insertion of attribute_score,monthBean,employeeBean,attributeBean,yearBean column 
public ProbationAssessmentM1Bean(Double attribute_score, MonthBean monthBean,
		EmployeeBean employeeBean, AttributeBean attributeBean, YearBean yearBean) {
	super();
	this.attribute_score = attribute_score;
	this.monthBean = monthBean;
	this.employeeBean = employeeBean;
	this.attributeBean = attributeBean;
	this.yearBean = yearBean;
}
@Id
@Column(name="probation_assessment_m1_id")
@GeneratedValue

//getter and setter method for column probation_assessment_m1_id of probation_assessment_direct_tbl
public int getProbation_assessment_m1_id() {
	return probation_assessment_m1_id;
}

public void setProbation_assessment_m1_id(int probation_assessment_m1_id) {
	this.probation_assessment_m1_id = probation_assessment_m1_id;
}
@Column(name="attribute_score")

//getter and setter method for column attribute_score of probation_assessment_direct_tbl
public Double getAttribute_score() {
	return attribute_score;
}

public void setAttribute_score(Double attribute_score) {
	this.attribute_score = attribute_score;
}
@ManyToOne
@JoinColumn(name="month_id")

//getter and setter method for column monthBean of probation_assessment_direct_tbl
public MonthBean getMonthBean() {
	return monthBean;
}

public void setMonthBean(MonthBean monthBean) {
	this.monthBean = monthBean;
}
@ManyToOne
@JoinColumn(name="employee_master_id")

//getter and setter method for column employeeBean of probation_assessment_direct_tbl
public EmployeeBean getEmployeeBean() {
	return employeeBean;
}

public void setEmployeeBean(EmployeeBean employeeBean) {
	this.employeeBean = employeeBean;
}
@ManyToOne
@JoinColumn(name="probation_attribute_id")
//getter and setter method for column attributeBean of probation_assessment_direct_tbl
public AttributeBean getAttributeBean() {
	return attributeBean;
}

public void setAttributeBean(AttributeBean attributeBean) {
	this.attributeBean = attributeBean;
}

@ManyToOne
@JoinColumn(name="year_id")
//getter and setter method for column yearBean of probation_assessment_direct_tbl
public YearBean getYearBean() {
	return yearBean;
}

public void setYearBean(YearBean yearBean) {
	this.yearBean = yearBean;
}


}
