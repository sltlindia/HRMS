package com.hrms.riskmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="probability_tbl")
public class ProbabilityBean implements Serializable{
	
	private int probability_id;
	private String probability_name;
	
	@Id
	@Column(name="probability_id")
    @GeneratedValue
	public int getProbability_id() {
		return probability_id;
	}
	
	public void setProbability_id(int probability_id) {
		this.probability_id = probability_id;
	}

	@Column(name="probability_name")
	public String getProbability_name() {
		return probability_name;
	}

	public void setProbability_name(String probability_name) {
		this.probability_name = probability_name;
	}
	
}
