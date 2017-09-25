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
@Table(name="probation_assessment_indirect_tbl")
public class ProbationAssessmentM2Bean {
	
	//Probation Assessment Bean for Adding,Updating,Deleting Scores of employees into table probation_assessment_indirect_tbl
	//getter and setter for inserting of all column into probation_assessment_indirect_tbl
	private int probation_assessment_m2_id;
	private Double attribute_m2_score;
	private String continue_for_next_month;
	private String warning_letter;
	private String termination_letter;
	private String comment_monthly;
	private MonthBean monthBean;
	private EmployeeBean employeeBean;
	private YearBean yearBean;
	private AttributeM2Bean attributeM2Bean;

	public ProbationAssessmentM2Bean() {
		super();
	}
	
	//Constructor Probation Assessment Bean for insertion of data into table probation_assessment_indirect_tbl
		//for Insertion of attribute_m2_score,monthBean,employeeBean,attributeM2Bean,yearBean column 
	public ProbationAssessmentM2Bean(Double attribute_m2_score, MonthBean monthBean,
			EmployeeBean employeeBean, AttributeM2Bean attributeM2Bean,YearBean yearBean) {
		super();
		this.attribute_m2_score = attribute_m2_score;
		this.monthBean = monthBean;
		this.employeeBean = employeeBean;
		this.attributeM2Bean = attributeM2Bean;
		this.yearBean = yearBean;
	}
	
	//constructor Probation Assessment Bean for updation of data into table probation_assessment_indirect_tbl
	//for Updation of attribute_m2_score,probation_assessment_m2_id column
	public ProbationAssessmentM2Bean(Double attribute_m2_score, int probation_assessment_m2_id) {
		super();
		this.attribute_m2_score = attribute_m2_score;
		this.probation_assessment_m2_id = probation_assessment_m2_id;
	}
	
	//Constructor Probation Assessment Bean for insertion of data into table probation_assessment_indirect_tbl
			//for Insertion of attribute_m2_score,monthBean,employeeBean,attributeM2Bean,yearBean column with continue_for_next_month,warning_letter,termination_letter
	public ProbationAssessmentM2Bean(Double attribute_m2_score, String continue_for_next_month, String warning_letter,
			String termination_letter, MonthBean monthBean, EmployeeBean employeeBean,
			AttributeM2Bean attributeM2Bean,YearBean yearBean) {
		super();
		this.attribute_m2_score = attribute_m2_score;
		this.continue_for_next_month = continue_for_next_month;
		this.warning_letter = warning_letter;
		this.termination_letter = termination_letter;
		this.monthBean = monthBean;
		this.employeeBean = employeeBean;
		this.attributeM2Bean = attributeM2Bean;
		this.yearBean = yearBean;
	}

	@Id
	@Column(name="probation_assessment_m2_id")
	@GeneratedValue
	
	//getter and setter method for column probation_assessment_m2_id of probation_assessment_indirect_tbl
	public int getProbation_assessment_m2_id() {
		return probation_assessment_m2_id;
	}

	public void setProbation_assessment_m2_id(int probation_assessment_m2_id) {
		this.probation_assessment_m2_id = probation_assessment_m2_id;
	}
	@Column(name="attribute_m2_score")
	//getter and setter method for column attribute_m2_score of probation_assessment_indirect_tbl
	public Double getAttribute_m2_score() {
		return attribute_m2_score;
	}
	
	public void setAttribute_m2_score(Double attribute_m2_score) {
		this.attribute_m2_score = attribute_m2_score;
	}

	
	@Column(name="continue_for_next_month")
	//getter and setter method for column continue_for_next_month of probation_assessment_indirect_tbl
	public String getContinue_for_next_month() {
		return continue_for_next_month;
	}

	public void setContinue_for_next_month(String continue_for_next_month) {
		this.continue_for_next_month = continue_for_next_month;
	}
	
	@Column(name="warning_letter")
	//getter and setter method for column warning_letter of probation_assessment_indirect_tbl
	public String getWarning_letter() {
		return warning_letter;
	}

	public void setWarning_letter(String warning_letter) {
		this.warning_letter = warning_letter;
	}

	@Column(name="termination_letter")
	//getter and setter method for column termination_letter of probation_assessment_indirect_tbl
	public String getTermination_letter() {
		return termination_letter;
	}

	public void setTermination_letter(String termination_letter) {
		this.termination_letter = termination_letter;
	}

	@ManyToOne
	@JoinColumn(name="month_id")
	//getter and setter method for column monthBean of probation_assessment_indirect_tbl
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
	@JoinColumn(name="probation_attributes_m2_id")
	//getter and setter method for column attributeM2Bean of probation_assessment_direct_tbl
	public AttributeM2Bean getAttributeM2Bean() {
		return attributeM2Bean;
	}

	public void setAttributeM2Bean(AttributeM2Bean attributeM2Bean) {
		this.attributeM2Bean = attributeM2Bean;
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

	@Column(name="comments_monthly")
	public String getComment_monthly() {
		return comment_monthly;
	}

	public void setComment_monthly(String comment_monthly) {
		this.comment_monthly = comment_monthly;
	}

	

	
	
	
	
	
	
	
	
}

