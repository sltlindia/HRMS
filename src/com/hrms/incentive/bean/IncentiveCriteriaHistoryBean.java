package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="incentive_criteria_history_tbl")
public class IncentiveCriteriaHistoryBean implements Serializable{

	
	private int incentive_criteria_history_id;
	private double target_to;
	private double target_from;
	private double eligible_incentive;
	private String date;
	
	private IncentiveCriteriaBean incentiveCriteriaBean;

	
	public IncentiveCriteriaHistoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	public IncentiveCriteriaHistoryBean(double target_to, double target_from, double eligible_incentive, String date,
			IncentiveCriteriaBean incentiveCriteriaBean) {
		super();
		this.target_to = target_to;
		this.target_from = target_from;
		this.eligible_incentive = eligible_incentive;
		this.date = date;
		this.incentiveCriteriaBean = incentiveCriteriaBean;
	}

	
	
	/**
	 * @return the incentive_criteria_history_id
	 */
	@Id 
    @Column(name="incentive_criteria_history_id")
    @GeneratedValue
	public int getIncentive_criteria_history_id() {
		return incentive_criteria_history_id;
	}

	/**
	 * @param incentive_criteria_history_id the incentive_criteria_history_id to set
	 */
	public void setIncentive_criteria_history_id(int incentive_criteria_history_id) {
		this.incentive_criteria_history_id = incentive_criteria_history_id;
	}

	
	
	/**
	 * @return the target_to
	 */
	@Column(name="target_to")
	public double getTarget_to() {
		return target_to;
	}

	/**
	 * @param target_to the target_to to set
	 */
	public void setTarget_to(double target_to) {
		this.target_to = target_to;
	}

	
	
	/**
	 * @return the target_from
	 */
	@Column(name="target_from")
	public double getTarget_from() {
		return target_from;
	}

	/**
	 * @param target_from the target_from to set
	 */
	public void setTarget_from(double target_from) {
		this.target_from = target_from;
	}

	
	
	/**
	 * @return the eligible_incentive
	 */
	@Column(name="eligible_incentive")
	public double getEligible_incentive() {
		return eligible_incentive;
	}

	/**
	 * @param eligible_incentive the eligible_incentive to set
	 */
	public void setEligible_incentive(double eligible_incentive) {
		this.eligible_incentive = eligible_incentive;
	}

	
	/**
	 * @return the date
	 */
	@Column(name="date")
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the incentiveCriteriaBean
	 */
	@ManyToOne
	@JoinColumn(name="incentive_criteria_id")
	public IncentiveCriteriaBean getIncentiveCriteriaBean() {
		return incentiveCriteriaBean;
	}

	/**
	 * @param incentiveCriteriaBean the incentiveCriteriaBean to set
	 */
	public void setIncentiveCriteriaBean(IncentiveCriteriaBean incentiveCriteriaBean) {
		this.incentiveCriteriaBean = incentiveCriteriaBean;
	}
	
	
}
