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
@Table(name="appraisal_white_section1_tbl")
public class AppraisalWhiteSection1Bean implements Serializable {

	
	private int appraisal_white_section1_id;
	private String roles_Responsibility;
	private String contribution_achievememt;
	private String obstacles;
	private String opportunities;
	
	private AppraisalBean appraisalBean;
	
	public AppraisalWhiteSection1Bean(String roles_Responsibility,String contribution_achievememt,String obstacles,String opportunities,AppraisalBean appraisalBean) {
		this.roles_Responsibility = roles_Responsibility;
		this.contribution_achievememt = contribution_achievememt;
		this.obstacles = obstacles;
		this.opportunities = opportunities;
		this.appraisalBean = appraisalBean;
	
	}
	

	
	
	
	public AppraisalWhiteSection1Bean(int appraisal_white_section1_id, String roles_Responsibility,
			String contribution_achievememt, String obstacles, String opportunities, AppraisalBean appraisalBean) {
		super();
		this.appraisal_white_section1_id = appraisal_white_section1_id;
		this.roles_Responsibility = roles_Responsibility;
		this.contribution_achievememt = contribution_achievememt;
		this.obstacles = obstacles;
		this.opportunities = opportunities;
		this.appraisalBean = appraisalBean;
	}





	public AppraisalWhiteSection1Bean() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="appraisal_white_section1_id")
    @GeneratedValue
	public int getAppraisal_white_section1_id() {
		return appraisal_white_section1_id;
	}

	public void setAppraisal_white_section1_id(int appraisal_white_section1_id) {
		this.appraisal_white_section1_id = appraisal_white_section1_id;
	}

	
	public String getRoles_Responsibility() {
		return roles_Responsibility;
	}

	public void setRoles_Responsibility(String roles_Responsibility) {
		this.roles_Responsibility = roles_Responsibility;
	}

	public String getContribution_achievememt() {
		return contribution_achievememt;
	}

	public void setContribution_achievememt(String contribution_achievememt) {
		this.contribution_achievememt = contribution_achievememt;
	}

	public String getObstacles() {
		return obstacles;
	}

	public void setObstacles(String obstacles) {
		this.obstacles = obstacles;
	}

	public String getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(String opportunities) {
		this.opportunities = opportunities;
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
