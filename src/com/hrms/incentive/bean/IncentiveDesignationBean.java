package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="incentive_designation_tbl")
public class IncentiveDesignationBean implements Serializable{
	
	
	private int incentive_designation_id;
	private String incentive_designation_name;
	
	
	/**
	 * @return the incentive_designation_id
	 */
	@Id 
    @Column(name="incentive_designation_id")
    @GeneratedValue
	public int getIncentive_designation_id() {
		return incentive_designation_id;
	}
	/**
	 * @param incentive_designation_id the incentive_designation_id to set
	 */
	public void setIncentive_designation_id(int incentive_designation_id) {
		this.incentive_designation_id = incentive_designation_id;
	}
	/**
	 * @return the incentive_designation_name
	 */
	
	@Column(name="incentive_designation_name")
	public String getIncentive_designation_name() {
		return incentive_designation_name;
	}
	/**
	 * @param incentive_designation_name the incentive_designation_name to set
	 */
	public void setIncentive_designation_name(String incentive_designation_name) {
		this.incentive_designation_name = incentive_designation_name;
	}
	
	
	
	

}
