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
@Table(name="probation_topmanagement_approval_tbl")
public class ProbationTopManagementApprovalBean implements Serializable {

	
	//ProbationTopManagementApprovalBean for Adding or updating Attributes into table probation_topmanagement_approval_tbl
	//getter and setter for inserting into probation_topmanagement_approval_tbl
	private int probation_topmanagement_approval_id;
	private int top_management_id;
	private String top_management_status;
	

	private ProbationAssessmentManagerBean probationAssessmentManagerBean;

	public ProbationTopManagementApprovalBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//ProbationTopManagementApprovalBean for updation of data into table probation_topmanagement_approval_tbl for adding top management approval
	public ProbationTopManagementApprovalBean(int probation_topmanagement_approval_id, int top_management_id,
			ProbationAssessmentManagerBean probationAssessmentManagerBean) {
		super();
		this.probation_topmanagement_approval_id = probation_topmanagement_approval_id;
		this.top_management_id = top_management_id;
		this.probationAssessmentManagerBean = probationAssessmentManagerBean;
	}
	//ProbationTopManagementApprovalBean for insertion of data into table probation_topmanagement_approval_tbl for adding top management approval
	public ProbationTopManagementApprovalBean(int top_management_id,
			ProbationAssessmentManagerBean probationAssessmentManagerBean,String top_management_status) {
		super();
		this.top_management_id = top_management_id;
		this.probationAssessmentManagerBean = probationAssessmentManagerBean;
		this.top_management_status = top_management_status;
	}

	
	@Id
	@Column(name="probation_topmanagement_approval_id")
    @GeneratedValue
    
  //getter and setter method for column probation_topmanagement_approval_id of probation_topmanagement_approval_tbl
	public int getProbation_topmanagement_approval_id() {
		return probation_topmanagement_approval_id;
	}

	public void setProbation_topmanagement_approval_id(int probation_topmanagement_approval_id) {
		this.probation_topmanagement_approval_id = probation_topmanagement_approval_id;
	}
	@Column(name="top_management_id")
	//getter and setter method for column top_management_id of probation_topmanagement_approval_tbl
	public int getTop_management_id() {
		return top_management_id;
	}

	public void setTop_management_id(int top_management_id) {
		this.top_management_id = top_management_id;
	}

	
	@ManyToOne
	@JoinColumn(name="probation_assessment_manager_id")
	//getter and setter method for column probationAssessmentManagerBean of probation_topmanagement_approval_tbl
	public ProbationAssessmentManagerBean getProbationAssessmentManagerBean() {
		return probationAssessmentManagerBean;
	}

	public void setProbationAssessmentManagerBean(ProbationAssessmentManagerBean probationAssessmentManagerBean) {
		this.probationAssessmentManagerBean = probationAssessmentManagerBean;
	}

	@Column(name="top_management_status")
	public String getTop_management_status() {
		return top_management_status;
	}

	public void setTop_management_status(String top_management_status) {
		this.top_management_status = top_management_status;
	}
	
	
}
