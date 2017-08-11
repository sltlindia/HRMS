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
@Table(name="appraisal_white_section2_tbl")
public class AppraisalWhiteCollarSection2Bean implements Serializable {

	private int appraisal_white_sectoin2_id;
	private String roles_and_responsibilities;
	private String major_accomplishments;
	private String opportunities_for_development;
	private String job_assignment;

	private AppraisalBean appraisalBean;

	public AppraisalWhiteCollarSection2Bean(String roles_and_responsibilities,String major_accomplishments,String opportunities_for_development,String job_assignment,AppraisalBean appraisalBean) {
		this.roles_and_responsibilities = roles_and_responsibilities;
		this.major_accomplishments = major_accomplishments;
		this.opportunities_for_development =opportunities_for_development;
		this.job_assignment = job_assignment;
		this.appraisalBean = appraisalBean;
	
	}
	
	
	
	
	
	
	
	
	
	
	public AppraisalWhiteCollarSection2Bean(int appraisal_white_sectoin2_id, String roles_and_responsibilities,
			String major_accomplishments, String opportunities_for_development, String job_assignment,
			AppraisalBean appraisalBean) {
		super();
		this.appraisal_white_sectoin2_id = appraisal_white_sectoin2_id;
		this.roles_and_responsibilities = roles_and_responsibilities;
		this.major_accomplishments = major_accomplishments;
		this.opportunities_for_development = opportunities_for_development;
		this.job_assignment = job_assignment;
		this.appraisalBean = appraisalBean;
	}










	public AppraisalWhiteCollarSection2Bean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="appraisal_white_sectoin2_id")
    @GeneratedValue
	public int getAppraisal_white_sectoin2_id() {
		return appraisal_white_sectoin2_id;
	}

	public void setAppraisal_white_sectoin2_id(int appraisal_white_sectoin2_id) {
		this.appraisal_white_sectoin2_id = appraisal_white_sectoin2_id;
	}

	public String getRoles_and_responsibilities() {
		return roles_and_responsibilities;
	}

	public void setRoles_and_responsibilities(String roles_and_responsibilities) {
		this.roles_and_responsibilities = roles_and_responsibilities;
	}

	public String getMajor_accomplishments() {
		return major_accomplishments;
	}

	public void setMajor_accomplishments(String major_accomplishments) {
		this.major_accomplishments = major_accomplishments;
	}

	public String getOpportunities_for_development() {
		return opportunities_for_development;
	}

	public void setOpportunities_for_development(String opportunities_for_development) {
		this.opportunities_for_development = opportunities_for_development;
	}

	public String getJob_assignment() {
		return job_assignment;
	}

	public void setJob_assignment(String job_assignment) {
		this.job_assignment = job_assignment;
	}

	@ManyToOne
	@JoinColumn(name="appraisal_id")
	public AppraisalBean getAppraisalBean() {
		return appraisalBean;
	}

	public void setAppraisalBean(AppraisalBean appraisalBean) {
		this.appraisalBean = appraisalBean;
	}
	
	
	
	
	

}
