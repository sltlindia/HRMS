package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prob_nature_rly_tbl")
public class ProblemNatureReplyBean {

	
	private int prob_nature_rly_id;
	private String prob_nature_rly_name;
	
	public ProblemNatureReplyBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProblemNatureReplyBean(int prob_nature_rly_id, String prob_nature_rly_name) {
		super();
		this.prob_nature_rly_id = prob_nature_rly_id;
		this.prob_nature_rly_name = prob_nature_rly_name;
	}
	
	@Id
	@GeneratedValue
	@Column(name="prob_nature_rly_id")
	public int getProb_nature_rly_id() {
		return prob_nature_rly_id;
	}
	public void setProb_nature_rly_id(int prob_nature_rly_id) {
		this.prob_nature_rly_id = prob_nature_rly_id;
	}
	
	
	@Column(name="prob_nature_rly_name")
	public String getProb_nature_rly_name() {
		return prob_nature_rly_name;
	}
	public void setProb_nature_rly_name(String prob_nature_rly_name) {
		this.prob_nature_rly_name = prob_nature_rly_name;
	}
	
	
	
	
	
}
