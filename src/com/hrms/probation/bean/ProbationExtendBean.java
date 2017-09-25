package com.hrms.probation.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="probation_extend_tbl")
public class ProbationExtendBean implements Serializable {

	//Probation Extend Bean for Adding,Updating,Deleting Data into table probation_extend_tbl
	//getter and setter for inserting into probation_extend_tbl
	private int probation_extend_id;
	private String extended_period;
	private String status;
	
	private ProbationAssessmentManagerBean probationAssessmentManagerBean;

	public ProbationExtendBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Constructor Probation Extend Bean for insertion of data into table proprobation_extend_tbl for adding extended Period
		//for Insertion of extended_period,status,probationAssessmentManagerBean 
	public ProbationExtendBean(String extended_period, String status,
			ProbationAssessmentManagerBean probationAssessmentManagerBean) {
		super();
		this.extended_period = extended_period;
		this.status = status;
		this.probationAssessmentManagerBean = probationAssessmentManagerBean;
	}

	@Id
	@Column(name="probation_extend_id")
    @GeneratedValue
    
  //getter and setter method for column probation_assessment_m1_id of probation_extend_tbl
	public int getProbation_extend_id() {
		return probation_extend_id;
	}

	public void setProbation_extend_id(int probation_extend_id) {
		this.probation_extend_id = probation_extend_id;
	}


	@Column(name="extended_period")
	 //getter and setter method for column extended_period of probation_extend_tbl
	public String getExtended_period() {
		return extended_period;
	}



	public void setExtended_period(String extended_period) {
		this.extended_period = extended_period;
	}


	@Column(name="status")
	 //getter and setter method for column status of probation_extend_tbl
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@ManyToOne
	@JoinColumn(name="probation_assessment_manager_id")
	//getter and setter method for column ProbationAssessmentManagerBean of probation_extend_tbl
	public ProbationAssessmentManagerBean getProbationAssessmentManagerBean() {
		return probationAssessmentManagerBean;
	}

	public void setProbationAssessmentManagerBean(ProbationAssessmentManagerBean probationAssessmentManagerBean) {
		this.probationAssessmentManagerBean = probationAssessmentManagerBean;
	}
	
	
	
	
}
