package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="incentive_criteria_tbl")
public class IncentiveCriteriaBean implements Serializable{
	
	private int incentive_criteria_id;
	private double target_to;
	private double target_from;
	private double eligible_incentive;
	
	public IncentiveCriteriaBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public IncentiveCriteriaBean(int incentive_criteria_id, double target_to, double target_from,
			double eligible_incentive) {
		super();
		this.incentive_criteria_id = incentive_criteria_id;
		this.target_to = target_to;
		this.target_from = target_from;
		this.eligible_incentive = eligible_incentive;
	}
	
	
	
	
	@Id 
    @Column(name="incentive_criteria_id")
    @GeneratedValue
	public int getIncentive_criteria_id() {
		return incentive_criteria_id;
	}
	public void setIncentive_criteria_id(int incentive_criteria_id) {
		this.incentive_criteria_id = incentive_criteria_id;
	}
	public double getTarget_to() {
		return target_to;
	}
	public void setTarget_to(double target_to) {
		this.target_to = target_to;
	}
	public double getTarget_from() {
		return target_from;
	}
	public void setTarget_from(double target_from) {
		this.target_from = target_from;
	}
	public double getEligible_incentive() {
		return eligible_incentive;
	}
	public void setEligible_incentive(double eligible_incentive) {
		this.eligible_incentive = eligible_incentive;
	}
	
	
	

}
